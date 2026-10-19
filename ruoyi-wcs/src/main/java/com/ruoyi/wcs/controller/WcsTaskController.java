package com.ruoyi.wcs.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wcs.domain.WcsTask;
import com.ruoyi.wcs.service.IWcsTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * 下发任务Controller
 * 
 * @author ruoyi
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/wcs/wcs_task")
public class WcsTaskController extends BaseController
{
    @Value("${ftp.host}")
    private String ftpHost;

    @Value("${ftp.port:21}")
    private int ftpPort;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp.password:}")
    private String ftpPassword;

    @Autowired
    private IWcsTaskService wcsTaskService;

    /**
     * 查询下发任务列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:list')")
    @GetMapping("/list")
    public TableDataInfo list(WcsTask wcsTask)
    {
        startPage();
        List<WcsTask> list = wcsTaskService.selectWcsTaskList(wcsTask);
        return getDataTable(list);
    }

    /**
     * 导出下发任务列表
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:export')")
    @Log(title = "下发任务", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WcsTask wcsTask)
    {
        List<WcsTask> list = wcsTaskService.selectWcsTaskList(wcsTask);
        ExcelUtil<WcsTask> util = new ExcelUtil<WcsTask>(WcsTask.class);
        return util.exportExcel(list, "tws task");
    }


    /**
     * 获取下发任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wcsTaskService.selectWcsTaskById(id));
    }

    /**
     * 新增下发任务
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:add')")
    @Log(title = "下发任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WcsTask wcsTask)
    {
        return toAjax(wcsTaskService.insertWcsTask(wcsTask));
    }

    /**
     * 修改下发任务
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:edit')")
    @Log(title = "下发任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WcsTask wcsTask)
    {
        return toAjax(wcsTaskService.updateWcsTask(wcsTask));
    }

    /**
     * 删除下发任务
     */
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:remove')")
    @Log(title = "下发任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wcsTaskService.deleteWcsTaskByIds(ids));
    }

    /**
     * 下载导入模板
     */
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<WcsTask> util = new ExcelUtil<WcsTask>(WcsTask.class);
        // 生成的模板名称，前端可通过此接口下载
        return util.importTemplateExcel("Task Data");
    }

    /**
     * 导入下发任务数据
     */
    @Log(title = "下发任务导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('wcs:wcs_task:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<WcsTask> util = new ExcelUtil<WcsTask>(WcsTask.class);
        // 解析Excel文件为实体列表
        List<WcsTask> taskList = util.importExcel(file.getInputStream());

        // 获取当前操作人
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        String operName = loginUser.getUsername();

        // 调用 Service 层方法进行数据库导入处理
        String message = wcsTaskService.importWcsTask(taskList, updateSupport, null);
        return AjaxResult.success(message);
    }

    /**
     * 获取指定 FTP 文件夹下的图片列表
     */
    @GetMapping("/imageList")
    public AjaxResult getImageList(@RequestParam("folderPath") String folderPath) {
        if (StringUtils.isEmpty(folderPath)) {
            return AjaxResult.error("文件夹路径为空");
        }

        List<String> imageFiles = new ArrayList<>();
        FTPClient ftpClient = new FTPClient();
        try {
//            ftpClient.connect("192.168.17.131", 21);
//            ftpClient.connect("10.41.220.9", 21);
//            ftpClient.login("ftp", "");

            Thread.sleep(300); // 保持防并发延迟
            ftpClient.setConnectTimeout(3000);
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.setSoTimeout(5000);
            ftpClient.setDataTimeout(5000);
            ftpClient.login(ftpUsername, ftpPassword);

            ftpClient.enterLocalPassiveMode();
            ftpClient.setControlEncoding("UTF-8");

            // 切换到记录的相对目录
            if (ftpClient.changeWorkingDirectory(folderPath)) {
                FTPFile[] files = ftpClient.listFiles();
                for (FTPFile file : files) {
                    if (file.isFile()) {
                        String name = file.getName().toLowerCase();
                        // 过滤出图片格式
                        if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                            imageFiles.add(file.getName());
                        }
                    }
                }
            }
        } catch (Exception e) {
            return AjaxResult.error("FTP连接或读取失败：" + e.getMessage());
        } finally {
            try { if (ftpClient.isConnected()) { ftpClient.disconnect(); } } catch (Exception ignored) {}
        }
        return AjaxResult.success(imageFiles);
    }

    /**
     * 获取单张图片的二进制流 (提供给前端 <img> 标签直接使用)
     */
    @GetMapping("/imageStream")
    public void getImageStream(@RequestParam("folderPath") String folderPath,
                               @RequestParam("fileName") String fileName,
                               @RequestParam(value = "download", required = false) String download,
                               HttpServletResponse response) {
        FTPClient ftpClient = new FTPClient();
        try {
//            ftpClient.connect("10.41.220.9", 21);
//            ftpClient.login("ftp", "");

            Thread.sleep(300); // 保持防并发延迟
            ftpClient.setConnectTimeout(3000);
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.setSoTimeout(5000);
            ftpClient.setDataTimeout(5000);
            ftpClient.login(ftpUsername, ftpPassword);

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // 必须设置为二进制

            if (ftpClient.changeWorkingDirectory(folderPath)) {
                InputStream inputStream = ftpClient.retrieveFileStream(fileName);
                if (inputStream != null) {
                    // 如果传了 download=1，触发浏览器下载；否则直接浏览器内渲染展示
                    if ("1".equals(download)) {
                        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                        response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
                    } else {
                        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                    }

                    OutputStream outputStream = response.getOutputStream();
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.flush();
                    inputStream.close();
                    ftpClient.completePendingCommand();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ftpClient.isConnected()) { ftpClient.disconnect(); } } catch (Exception ignored) {}
        }
    }

}
