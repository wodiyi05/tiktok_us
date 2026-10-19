-- ----------------------------
-- 1、存储每一个已配置的 jobDetail 的详细信息
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_job_details]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_job_details]
GO

CREATE TABLE [dbo].[qrtz_job_details] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [job_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [job_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [description] nvarchar(250) COLLATE Chinese_PRC_CI_AS DEFAULT NULL NULL,
  [job_class_name] nvarchar(250) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [is_durable] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [is_nonconcurrent] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [is_update_data] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [requests_recovery] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [job_data] varbinary(max)  NULL,
  PRIMARY key(sched_name,job_name,job_group)
)
GO

ALTER TABLE [dbo].[qrtz_job_details] SET (LOCK_ESCALATION = TABLE)
GO

-- ----------------------------
-- 2、 存储已配置的 Trigger 的信息
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_triggers]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_triggers]
GO

CREATE TABLE [dbo].[qrtz_triggers] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [job_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [job_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [description] nvarchar(250) COLLATE Chinese_PRC_CI_AS  NULL,
  [next_fire_time] bigint  NULL,
  [prev_fire_time] bigint  NULL,
  [priority] int  NULL,
  [trigger_state] nvarchar(16) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_type] nvarchar(8) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [start_time] bigint  NOT NULL,
  [end_time] bigint  NULL,
  [calendar_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [misfire_instr] smallint  NULL,
  [job_data] varbinary(max)  NULL,
  PRIMARY key(sched_name,trigger_name,trigger_group),
  FOREIGN KEY (sched_name,job_name,job_group) REFERENCES QRTZ_JOB_DETAILS(sched_name,job_name,job_group)
)
GO

ALTER TABLE [dbo].[qrtz_triggers] SET (LOCK_ESCALATION = TABLE)
GO

-- ----------------------------
-- 3、 存储简单的 Trigger，包括重复次数，间隔，以及已触发的次数
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_simple_triggers]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_simple_triggers]
GO

CREATE TABLE [dbo].[qrtz_simple_triggers] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [repeat_count] bigint  NOT NULL,
  [repeat_interval] bigint  NOT NULL,
  [times_triggered] bigint  NOT NULL,
  primary key (sched_name,trigger_name,trigger_group),
  foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)
GO

ALTER TABLE [dbo].[qrtz_simple_triggers] SET (LOCK_ESCALATION = TABLE)
GO
-- ----------------------------
-- 4、 存储 Cron Trigger，包括 Cron 表达式和时区信息
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_cron_triggers]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_cron_triggers]
GO

CREATE TABLE [dbo].[qrtz_cron_triggers] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [cron_expression] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [time_zone_id] nvarchar(80) COLLATE Chinese_PRC_CI_AS  NULL,
  primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)
GO

ALTER TABLE [dbo].[qrtz_cron_triggers] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- 5、 Trigger 作为 Blob 类型存储(用于 Quartz 用户用 JDBC 创建他们自己定制的 Trigger 类型，JobStore 并不知道如何存储实例的时候)
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_blob_triggers]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_blob_triggers]
GO

CREATE TABLE [dbo].[qrtz_blob_triggers] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [blob_data] varbinary(max)  NULL,
   primary key (sched_name,trigger_name,trigger_group),
    foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)
GO

ALTER TABLE [dbo].[qrtz_blob_triggers] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- 6、 以 Blob 类型存储存放日历信息， quartz可配置一个日历来指定一个时间范围
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_calendars]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_calendars]
GO

CREATE TABLE [dbo].[qrtz_calendars] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [calendar_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [calendar] varbinary(max)  NOT NULL,
  primary key (sched_name,calendar_name)
)
GO

ALTER TABLE [dbo].[qrtz_calendars] SET (LOCK_ESCALATION = TABLE)
GO

-- ----------------------------
-- 7、 存储已暂停的 Trigger 组的信息
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_paused_trigger_grps]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_paused_trigger_grps]
GO

CREATE TABLE [dbo].[qrtz_paused_trigger_grps] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  primary key (sched_name,trigger_group)
)
GO

ALTER TABLE [dbo].[qrtz_paused_trigger_grps] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- 8、 存储与已触发的 Trigger 相关的状态信息，以及相联 Job 的执行信息
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_fired_triggers]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_fired_triggers]
GO

CREATE TABLE [dbo].[qrtz_fired_triggers] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [entry_id] nvarchar(95) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [instance_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [fired_time] bigint  NOT NULL,
  [sched_time] bigint  NOT NULL,
  [priority] int  NOT NULL,
  [state] nvarchar(16) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [job_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [job_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [is_nonconcurrent] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NULL,
  [requests_recovery] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NULL,
  primary key (sched_name,entry_id)
)
GO

ALTER TABLE [dbo].[qrtz_fired_triggers] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- 9、 存储少量的有关 Scheduler 的状态信息，假如是用于集群中，可以看到其他的 Scheduler 实例
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_scheduler_state]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_scheduler_state]
GO

CREATE TABLE [dbo].[qrtz_scheduler_state] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [instance_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [last_checkin_time] bigint  NOT NULL,
  [checkin_interval] bigint  NOT NULL,
  primary key (sched_name,instance_name)
)
GO

ALTER TABLE [dbo].[qrtz_scheduler_state] SET (LOCK_ESCALATION = TABLE)
GO
-- ----------------------------
-- 10、 存储程序的悲观锁的信息(假如使用了悲观锁)
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_locks]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_locks]
GO

CREATE TABLE [dbo].[qrtz_locks] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [lock_name] nvarchar(40) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  primary key (sched_name,lock_name)
)
GO

ALTER TABLE [dbo].[qrtz_locks] SET (LOCK_ESCALATION = TABLE)
GO

-- ----------------------------
-- 11
-- ---------------------------- 
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[qrtz_simprop_triggers]') AND type IN ('U'))
	DROP TABLE [dbo].[qrtz_simprop_triggers]
GO

CREATE TABLE [dbo].[qrtz_simprop_triggers] (
  [sched_name] nvarchar(120) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_name] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [trigger_group] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [str_prop_1] nvarchar(512) COLLATE Chinese_PRC_CI_AS  NULL,
  [str_prop_2] nvarchar(512) COLLATE Chinese_PRC_CI_AS  NULL,
  [str_prop_3] nvarchar(512) COLLATE Chinese_PRC_CI_AS  NULL,
  [int_prop_1] int  NULL,
  [int_prop_2] int  NULL,
  [long_prop_1] bigint  NULL,
  [long_prop_2] bigint  NULL,
  [dec_prop_1] decimal(13,4)  NULL,
  [dec_prop_2] decimal(13,4)  NULL,
  [bool_prop_1] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NULL,
  [bool_prop_2] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NULL,
  primary key (sched_name,trigger_name,trigger_group),
  foreign key (sched_name,trigger_name,trigger_group) references QRTZ_TRIGGERS(sched_name,trigger_name,trigger_group)
)
GO

ALTER TABLE [dbo].[qrtz_simprop_triggers] SET (LOCK_ESCALATION = TABLE)
GO

