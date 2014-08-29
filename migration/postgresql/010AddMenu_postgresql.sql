-- Aug 29, 2014 5:30:26 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (AD_Client_ID,AD_Menu_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES (0,1000000,0,TO_TIMESTAMP('2014-08-29 17:30:25','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','Y','Attendance Record',TO_TIMESTAMP('2014-08-29 17:30:25','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:30:26 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000000 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:30:26 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:30:26','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000000,0,999,TO_TIMESTAMP('2014-08-29 17:30:26','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:30:38 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='Y',Name='Registro de Asistencia',Updated=TO_TIMESTAMP('2014-08-29 17:30:38','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=1000000 AND AD_Language='es_MX'
;

-- Aug 29, 2014 5:30:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000001,0,1000007,TO_TIMESTAMP('2014-08-29 17:30:56','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Day',TO_TIMESTAMP('2014-08-29 17:30:56','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:30:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000001 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:30:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:30:57','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000001,0,999,TO_TIMESTAMP('2014-08-29 17:30:57','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:12 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000002,0,1000001,TO_TIMESTAMP('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100,'U','Y','Y','N','N','N','Calendar',TO_TIMESTAMP('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:12 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000002 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:31:13 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000002,0,999,TO_TIMESTAMP('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000003,0,1000010,TO_TIMESTAMP('2014-08-29 17:31:28','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Journal',TO_TIMESTAMP('2014-08-29 17:31:28','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000003 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:31:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:31:29','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000003,0,999,TO_TIMESTAMP('2014-08-29 17:31:29','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:35 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET EntityType='ECA02',Updated=TO_TIMESTAMP('2014-08-29 17:31:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=1000002
;

-- Aug 29, 2014 5:31:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000004,0,1000008,TO_TIMESTAMP('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Journal Day',TO_TIMESTAMP('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000004 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:31:51 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000004,0,999,TO_TIMESTAMP('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:15 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000005,0,1000009,TO_TIMESTAMP('2014-08-29 17:32:14','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Attendance Record',TO_TIMESTAMP('2014-08-29 17:32:14','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:15 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000005 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:32:15 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:32:15','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000005,0,999,TO_TIMESTAMP('2014-08-29 17:32:15','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu ("action",AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000006,0,1000003,TO_TIMESTAMP('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Incidence Group',TO_TIMESTAMP('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000006 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:32:42 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_TIMESTAMP('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000006,0,999,TO_TIMESTAMP('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=6,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=236
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=7,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=183
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=8,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=160
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=9,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=278
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=10,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=345
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=11,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=53014
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=12,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=53108
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=13,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000000
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=14,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=15,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=16,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=17,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=18,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=19,Updated=TO_TIMESTAMP('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000005
;

-- Aug 29, 2014 5:32:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=20,Updated=TO_TIMESTAMP('2014-08-29 17:32:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000006
;

-- Aug 29, 2014 5:32:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_TIMESTAMP('2014-08-29 17:32:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:51 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_TIMESTAMP('2014-08-29 17:32:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:51 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_TIMESTAMP('2014-08-29 17:32:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:54 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_TIMESTAMP('2014-08-29 17:32:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:54 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_TIMESTAMP('2014-08-29 17:32:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:54 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_TIMESTAMP('2014-08-29 17:32:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:55 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_TIMESTAMP('2014-08-29 17:32:55','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:55 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_TIMESTAMP('2014-08-29 17:32:55','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_TIMESTAMP('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000005
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_TIMESTAMP('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_TIMESTAMP('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_TIMESTAMP('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_TIMESTAMP('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:58 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_TIMESTAMP('2014-08-29 17:32:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000006
;

-- Aug 29, 2014 5:32:58 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_TIMESTAMP('2014-08-29 17:32:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:59 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_TIMESTAMP('2014-08-29 17:32:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:59 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_TIMESTAMP('2014-08-29 17:32:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:59 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=5,Updated=TO_TIMESTAMP('2014-08-29 17:32:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:33:01 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=14,Updated=TO_TIMESTAMP('2014-08-29 17:33:01','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:33:02 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_TIMESTAMP('2014-08-29 17:33:02','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:33:03 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_TIMESTAMP('2014-08-29 17:33:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:33:03 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=5,Updated=TO_TIMESTAMP('2014-08-29 17:33:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:33:03 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=6,Updated=TO_TIMESTAMP('2014-08-29 17:33:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_ELEMENT_TRL (AD_Element_ID, AD_LANGUAGE, AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy, Name, PrintName, Description, Help, IsTranslated) SELECT m.AD_Element_ID, l.AD_LANGUAGE, m.AD_Client_ID, m.AD_Org_ID, m.IsActive, m.Created, m.CreatedBy, m.Updated, m.UpdatedBy, m.Name, m.PrintName, m.Description, m.Help, 'N' FROM AD_ELEMENT m, AD_LANGUAGE l WHERE l.IsActive = 'Y' AND l.IsSystemLanguage = 'Y' AND AD_Element_ID || AD_LANGUAGE NOT IN (SELECT AD_Element_ID || AD_LANGUAGE FROM AD_ELEMENT_TRL)
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_COLUMN SET AD_Element_id = (SELECT AD_Element_ID FROM AD_ELEMENT e WHERE UPPER(AD_COLUMN.ColumnName)=UPPER(e.ColumnName)) WHERE AD_Element_ID IS NULL
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_ELEMENT_TRL WHERE AD_Element_ID IN (SELECT AD_Element_ID FROM AD_ELEMENT e WHERE NOT EXISTS (SELECT 1 FROM AD_COLUMN c WHERE UPPER(e.ColumnName)=UPPER(c.ColumnName)) AND NOT EXISTS (SELECT 1 FROM AD_PROCESS_PARA p WHERE UPPER(e.ColumnName)=UPPER(p.ColumnName)))
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE FROM AD_ELEMENT WHERE AD_Element_ID >= 1000000 AND NOT EXISTS (SELECT 1 FROM AD_COLUMN c WHERE UPPER(AD_ELEMENT.ColumnName)=UPPER(c.ColumnName)) AND NOT EXISTS (SELECT 1 FROM AD_PROCESS_PARA p WHERE UPPER(AD_ELEMENT.ColumnName)=UPPER(p.ColumnName))
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_COLUMN SET ColumnName=e.ColumnName,Name=e.Name,Description=e.Description,Help=e.Help, Updated = CURRENT_TIMESTAMP FROM AD_ELEMENT e WHERE AD_COLUMN.AD_Element_ID=e.AD_Element_ID AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE AD_COLUMN.AD_Element_ID=e.AD_Element_ID AND (AD_COLUMN.ColumnName <> e.ColumnName OR AD_COLUMN.Name <> e.Name OR COALESCE(AD_COLUMN.Description,' ') <> COALESCE(e.Description,' ') OR COALESCE(AD_COLUMN.Help,' ') <> COALESCE(e.Help,' ')))
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD SET Name=e.Name,Description=e.Description,Help=e.Help, Updated = CURRENT_TIMESTAMP FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID AND AD_FIELD.IsCentrallyMaintained='Y' AND AD_FIELD.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e, AD_COLUMN c WHERE AD_FIELD.AD_Column_ID=c.AD_Column_ID AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL AND (AD_FIELD.Name <> e.Name OR COALESCE(AD_FIELD.Description,' ') <> COALESCE(e.Description,' ') OR COALESCE(AD_FIELD.Help,' ') <> COALESCE(e.Help,' ')))
;

-- Aug 29, 2014 5:34:46 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD_TRL SET Name = (SELECT e.Name FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), Description = (SELECT e.Description FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), Help = (SELECT e.Help FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), IsTranslated = (SELECT e.IsTranslated FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), Updated = CURRENT_TIMESTAMP WHERE EXISTS (SELECT 1 FROM AD_FIELD f, AD_ELEMENT_TRL e, AD_COLUMN c WHERE AD_FIELD_TRL.AD_Field_ID=f.AD_Field_ID AND f.AD_Column_ID=c.AD_Column_ID AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL AND AD_FIELD_TRL.AD_LANGUAGE=e.AD_LANGUAGE AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND (AD_FIELD_TRL.Name <> e.Name OR COALESCE(AD_FIELD_TRL.Description,' ') <> COALESCE(e.Description,' ') OR COALESCE(AD_FIELD_TRL.Help,' ') <> COALESCE(e.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD SET Name = (SELECT e.PO_Name FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID), Description = (SELECT e.PO_Description FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID), Help = (SELECT e.PO_Help FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID), Updated = CURRENT_TIMESTAMP WHERE AD_FIELD.IsCentrallyMaintained='Y' AND AD_FIELD.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e, AD_COLUMN c WHERE AD_FIELD.AD_Column_ID=c.AD_Column_ID AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL AND (AD_FIELD.Name <> e.PO_Name OR COALESCE(AD_FIELD.Description,' ') <> COALESCE(e.PO_Description,' ') OR COALESCE(AD_FIELD.Help,' ') <> COALESCE(e.PO_Help,' ')) AND e.PO_Name IS NOT NULL) AND EXISTS (SELECT 1 FROM AD_TAB t, AD_WINDOW w WHERE AD_FIELD.AD_Tab_ID=t.AD_Tab_ID AND t.AD_Window_ID=w.AD_Window_ID AND w.IsSOTrx='N')
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD_TRL SET Name = (SELECT e.PO_Name FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), Description = (SELECT e.PO_Description FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), Help = (SELECT e.PO_Help FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), IsTranslated = (SELECT e.IsTranslated FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f WHERE e.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID), Updated = CURRENT_TIMESTAMP WHERE EXISTS (SELECT 1 FROM AD_FIELD f, AD_ELEMENT_TRL e, AD_COLUMN c WHERE AD_FIELD_TRL.AD_Field_ID=f.AD_Field_ID AND f.AD_Column_ID=c.AD_Column_ID AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL AND AD_FIELD_TRL.AD_LANGUAGE=e.AD_LANGUAGE AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND (AD_FIELD_TRL.Name <> e.PO_Name OR COALESCE(AD_FIELD_TRL.Description,' ') <> COALESCE(e.PO_Description,' ') OR COALESCE(AD_FIELD_TRL.Help,' ') <> COALESCE(e.PO_Help,' ')) AND e.PO_Name IS NOT NULL) AND EXISTS (SELECT 1 FROM AD_FIELD f, AD_TAB t, AD_WINDOW w WHERE AD_FIELD_TRL.AD_Field_ID=f.AD_Field_ID AND f.AD_Tab_ID=t.AD_Tab_ID AND t.AD_Window_ID=w.AD_Window_ID AND w.IsSOTrx='N')
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD SET Name = (SELECT p.Name FROM AD_PROCESS p, AD_COLUMN c WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID), Description = (SELECT p.Description FROM AD_PROCESS p, AD_COLUMN c WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID), Help = (SELECT p.Help FROM AD_PROCESS p, AD_COLUMN c WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=AD_FIELD.AD_Column_ID), Updated = CURRENT_TIMESTAMP WHERE AD_FIELD.IsCentrallyMaintained='Y' AND AD_FIELD.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_PROCESS p, AD_COLUMN c WHERE c.AD_Process_ID=p.AD_Process_ID AND AD_FIELD.AD_Column_ID=c.AD_Column_ID AND (AD_FIELD.Name<>p.Name OR COALESCE(AD_FIELD.Description,' ')<>COALESCE(p.Description,' ') OR COALESCE(AD_FIELD.Help,' ')<>COALESCE(p.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD_TRL SET Name = (SELECT p.Name FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID AND p.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE), Description = (SELECT p.Description FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID AND p.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE), Help = (SELECT p.Help FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID AND p.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE), IsTranslated = (SELECT p.IsTranslated FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID AND p.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE), Updated = CURRENT_TIMESTAMP WHERE EXISTS (SELECT 1 FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f WHERE c.AD_Process_ID=p.AD_Process_ID AND f.AD_Column_ID=c.AD_Column_ID AND f.AD_Field_ID=AD_FIELD_TRL.AD_Field_ID AND p.AD_LANGUAGE=AD_FIELD_TRL.AD_LANGUAGE AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND (AD_FIELD_TRL.Name<>p.Name OR COALESCE(AD_FIELD_TRL.Description,' ')<>COALESCE(p.Description,' ') OR COALESCE(AD_FIELD_TRL.Help,' ')<>COALESCE(p.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_BROWSE_FIELD SET Name=e.Name,Description=e.Description,Help=e.Help, Updated = CURRENT_TIMESTAMP FROM AD_ELEMENT e WHERE e.AD_Element_ID=AD_BROWSE_FIELD.AD_Element_ID AND AD_BROWSE_FIELD.IsCentrallyMaintained='Y' AND AD_BROWSE_FIELD.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE AD_BROWSE_FIELD.AD_Element_ID=e.AD_Element_ID AND (AD_BROWSE_FIELD.Name <> e.Name OR COALESCE(AD_BROWSE_FIELD.Description,' ') <> COALESCE(e.Description,' ') OR COALESCE(AD_BROWSE_FIELD.Help,' ') <> COALESCE(e.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_BROWSE_FIELD_TRL SET Name = (SELECT e.Name FROM AD_ELEMENT_TRL e , AD_BROWSE_FIELD f WHERE e.AD_LANGUAGE=AD_BROWSE_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID AND f.AD_Browse_Field_ID=AD_BROWSE_FIELD_TRL.AD_Browse_Field_ID), Description = (SELECT e.Description FROM AD_ELEMENT_TRL e, AD_BROWSE_FIELD f WHERE e.AD_LANGUAGE=AD_BROWSE_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID AND f.AD_Browse_Field_ID=AD_BROWSE_FIELD_TRL.AD_Browse_Field_ID), Help = (SELECT e.Help FROM AD_ELEMENT_TRL e, AD_BROWSE_FIELD f WHERE e.AD_LANGUAGE=AD_BROWSE_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID AND f.AD_Browse_Field_ID=AD_BROWSE_FIELD_TRL.AD_Browse_Field_ID), IsTranslated = (SELECT e.IsTranslated FROM AD_ELEMENT_TRL e, AD_BROWSE_FIELD f WHERE e.AD_LANGUAGE=AD_BROWSE_FIELD_TRL.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID AND f.AD_Browse_Field_ID=AD_BROWSE_FIELD_TRL.AD_Browse_Field_ID), Updated = CURRENT_TIMESTAMP WHERE EXISTS (SELECT 1 FROM AD_BROWSE_FIELD f, AD_ELEMENT_TRL e WHERE AD_BROWSE_FIELD_TRL.AD_Browse_Field_ID=f.AD_Browse_Field_ID AND f.AD_Element_ID=e.AD_Element_ID AND AD_BROWSE_FIELD_TRL.AD_LANGUAGE=e.AD_LANGUAGE AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND (AD_BROWSE_FIELD_TRL.Name <> e.Name OR COALESCE(AD_BROWSE_FIELD_TRL.Description,' ') <> COALESCE(e.Description,' ') OR COALESCE(AD_BROWSE_FIELD_TRL.Help,' ') <> COALESCE(e.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PROCESS_PARA SET ColumnName = (SELECT e.ColumnName FROM AD_ELEMENT e WHERE UPPER(e.ColumnName)=UPPER(AD_PROCESS_PARA.ColumnName)) WHERE AD_PROCESS_PARA.IsCentrallyMaintained='Y' AND AD_PROCESS_PARA.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE UPPER(e.ColumnName)=UPPER(AD_PROCESS_PARA.ColumnName) AND e.ColumnName<>AD_PROCESS_PARA.ColumnName)
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PROCESS_PARA SET IsCentrallyMaintained = 'N' WHERE IsCentrallyMaintained <> 'N' AND NOT EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE AD_PROCESS_PARA.ColumnName=e.ColumnName)
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PROCESS_PARA SET Name = (SELECT e.Name FROM AD_ELEMENT e WHERE e.ColumnName=AD_PROCESS_PARA.ColumnName), Description = (SELECT e.Description FROM AD_ELEMENT e WHERE e.ColumnName=AD_PROCESS_PARA.ColumnName), Help = (SELECT e.Help FROM AD_ELEMENT e WHERE e.ColumnName=AD_PROCESS_PARA.ColumnName), Updated = CURRENT_TIMESTAMP WHERE AD_PROCESS_PARA.IsCentrallyMaintained='Y' AND AD_PROCESS_PARA.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE e.ColumnName=AD_PROCESS_PARA.ColumnName AND (AD_PROCESS_PARA.Name <> e.Name OR COALESCE(AD_PROCESS_PARA.Description,' ') <> COALESCE(e.Description,' ') OR COALESCE(AD_PROCESS_PARA.Help,' ') <> COALESCE(e.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PROCESS_PARA_TRL SET Name = (SELECT et.Name FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f WHERE et.AD_LANGUAGE=AD_PROCESS_PARA_TRL.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=AD_PROCESS_PARA_TRL.AD_Process_Para_ID), Description = (SELECT et.Description FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f WHERE et.AD_LANGUAGE=AD_PROCESS_PARA_TRL.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=AD_PROCESS_PARA_TRL.AD_Process_Para_ID), Help = (SELECT et.Help FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f WHERE et.AD_LANGUAGE=AD_PROCESS_PARA_TRL.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=AD_PROCESS_PARA_TRL.AD_Process_Para_ID), IsTranslated = (SELECT et.IsTranslated FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f WHERE et.AD_LANGUAGE=AD_PROCESS_PARA_TRL.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=AD_PROCESS_PARA_TRL.AD_Process_Para_ID), Updated = CURRENT_TIMESTAMP WHERE EXISTS (SELECT 1 FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f WHERE et.AD_LANGUAGE=AD_PROCESS_PARA_TRL.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=AD_PROCESS_PARA_TRL.AD_Process_Para_ID AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND (AD_PROCESS_PARA_TRL.Name <> et.Name OR COALESCE(AD_PROCESS_PARA_TRL.Description,' ') <> COALESCE(et.Description,' ') OR COALESCE(AD_PROCESS_PARA_TRL.Help,' ') <> COALESCE(et.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE SET Name = (SELECT w.Name FROM AD_WINDOW w WHERE w.AD_Window_ID=AD_WF_NODE.AD_Window_ID), Description = (SELECT w.Description FROM AD_WINDOW w WHERE w.AD_Window_ID=AD_WF_NODE.AD_Window_ID), Help = (SELECT w.Help FROM AD_WINDOW w WHERE w.AD_Window_ID=AD_WF_NODE.AD_Window_ID) WHERE AD_WF_NODE.IsCentrallyMaintained = 'Y' AND EXISTS (SELECT 1 FROM AD_WINDOW w WHERE w.AD_Window_ID=AD_WF_NODE.AD_Window_ID AND (w.Name <> AD_WF_NODE.Name OR COALESCE(w.Description,' ') <> COALESCE(AD_WF_NODE.Description,' ') OR COALESCE(w.Help,' ') <> COALESCE(AD_WF_NODE.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE_TRL SET Name = (SELECT t.Name FROM AD_WINDOW_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE), Description = (SELECT t.Description FROM AD_WINDOW_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE), Help = (SELECT t.Help FROM AD_WINDOW_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_WINDOW_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE AND n.IsCentrallyMaintained='Y' AND n.IsActive='Y' AND (AD_WF_NODE_TRL.Name <> t.Name OR COALESCE(AD_WF_NODE_TRL.Description,' ') <> COALESCE(t.Description,' ') OR COALESCE(AD_WF_NODE_TRL.Help,' ') <> COALESCE(t.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE SET Name=f.Name,Description=f.Description,Help=f.Help FROM AD_FORM f WHERE f.AD_Form_ID=AD_WF_NODE.AD_Form_ID AND AD_WF_NODE.IsCentrallyMaintained = 'Y' AND EXISTS (SELECT 1 FROM AD_FORM f WHERE f.AD_Form_ID=AD_WF_NODE.AD_Form_ID AND (f.Name <> AD_WF_NODE.Name OR COALESCE(f.Description,' ') <> COALESCE(AD_WF_NODE.Description,' ') OR COALESCE(f.Help,' ') <> COALESCE(AD_WF_NODE.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE_TRL SET Name=t.Name,Description=t.Description,Help=t.Help FROM AD_FORM_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Form_ID=t.AD_Form_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE AND EXISTS (SELECT 1 FROM AD_FORM_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Form_ID=t.AD_Form_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE AND n.IsCentrallyMaintained='Y' AND n.IsActive='Y' AND (AD_WF_NODE_TRL.Name <> t.Name OR COALESCE(AD_WF_NODE_TRL.Description,' ') <> COALESCE(t.Description,' ') OR COALESCE(AD_WF_NODE_TRL.Help,' ') <> COALESCE(t.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE SET Name=f.Name,Description=f.Description,Help=f.Help FROM AD_PROCESS f WHERE f.AD_Process_ID=AD_WF_NODE.AD_Process_ID AND AD_WF_NODE.IsCentrallyMaintained = 'Y' AND EXISTS (SELECT 1 FROM AD_PROCESS f WHERE f.AD_Process_ID=AD_WF_NODE.AD_Process_ID AND (f.Name <> AD_WF_NODE.Name OR COALESCE(f.Description,' ') <> COALESCE(AD_WF_NODE.Description,' ') OR COALESCE(f.Help,' ') <> COALESCE(AD_WF_NODE.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE_TRL SET Name=t.Name,Description=t.Description,Help=t.Help FROM AD_PROCESS_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Process_ID=t.AD_Process_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE AND EXISTS (SELECT 1 FROM AD_PROCESS_TRL t, AD_WF_NODE n WHERE AD_WF_NODE_TRL.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Process_ID=t.AD_Process_ID AND AD_WF_NODE_TRL.AD_LANGUAGE=t.AD_LANGUAGE AND n.IsCentrallyMaintained='Y' AND n.IsActive='Y' AND (AD_WF_NODE_TRL.Name <> t.Name OR COALESCE(AD_WF_NODE_TRL.Description,' ') <> COALESCE(t.Description,' ') OR COALESCE(AD_WF_NODE_TRL.Help,' ') <> COALESCE(t.Help,' ')))
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM SET Name = (SELECT e.Name FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_PRINTFORMATITEM.AD_Column_ID) WHERE AD_PRINTFORMATITEM.IsCentrallyMaintained='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_PRINTFORMATITEM.AD_Column_ID AND e.Name<>AD_PRINTFORMATITEM.Name) AND EXISTS (SELECT 1 FROM AD_CLIENT WHERE AD_Client_ID=AD_PRINTFORMATITEM.AD_Client_ID AND IsMultiLingualDocument='Y')
;

-- Aug 29, 2014 5:34:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM SET PrintName = (SELECT e.PrintName FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_PRINTFORMATITEM.AD_Column_ID) WHERE AD_PRINTFORMATITEM.IsCentrallyMaintained='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e, AD_COLUMN c, AD_PRINTFORMAT pf WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=AD_PRINTFORMATITEM.AD_Column_ID AND LENGTH(AD_PRINTFORMATITEM.PrintName) > 0 AND e.PrintName<>AD_PRINTFORMATITEM.PrintName AND pf.AD_PrintFormat_ID=AD_PRINTFORMATITEM.AD_PrintFormat_ID AND pf.IsForm='N' AND IsTableBased='Y') AND EXISTS (SELECT 1 FROM AD_CLIENT WHERE AD_Client_ID=AD_PRINTFORMATITEM.AD_Client_ID AND IsMultiLingualDocument='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM_TRL SET PrintName = (SELECT e.PrintName FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_PRINTFORMATITEM pfi WHERE e.AD_LANGUAGE=AD_PRINTFORMATITEM_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID AND pfi.AD_PrintFormatItem_ID=AD_PRINTFORMATITEM_TRL.AD_PrintFormatItem_ID) WHERE EXISTS (SELECT 1 FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_PRINTFORMATITEM pfi, AD_PRINTFORMAT pf WHERE e.AD_LANGUAGE=AD_PRINTFORMATITEM_TRL.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID AND pfi.AD_PrintFormatItem_ID=AD_PRINTFORMATITEM_TRL.AD_PrintFormatItem_ID AND pfi.IsCentrallyMaintained='Y' AND LENGTH(pfi.PrintName) > 0 AND (e.PrintName<>AD_PRINTFORMATITEM_TRL.PrintName OR AD_PRINTFORMATITEM_TRL.PrintName IS NULL) AND pf.AD_PrintFormat_ID=pfi.AD_PrintFormat_ID AND pf.IsForm='N' AND IsTableBased='Y') AND EXISTS (SELECT 1 FROM AD_CLIENT WHERE AD_Client_ID=AD_PRINTFORMATITEM_TRL.AD_Client_ID AND IsMultiLingualDocument='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM_TRL SET PrintName = (SELECT pfi.PrintName FROM AD_PRINTFORMATITEM pfi WHERE pfi.AD_PrintFormatItem_ID=AD_PRINTFORMATITEM_TRL.AD_PrintFormatItem_ID) WHERE EXISTS (SELECT 1 FROM AD_PRINTFORMATITEM pfi, AD_PRINTFORMAT pf WHERE pfi.AD_PrintFormatItem_ID=AD_PRINTFORMATITEM_TRL.AD_PrintFormatItem_ID AND pfi.IsCentrallyMaintained='Y' AND LENGTH(pfi.PrintName) > 0 AND pfi.PrintName<>AD_PRINTFORMATITEM_TRL.PrintName AND pf.AD_PrintFormat_ID=pfi.AD_PrintFormat_ID AND pf.IsForm='N' AND pf.IsTableBased='Y') AND EXISTS (SELECT 1 FROM AD_CLIENT WHERE AD_Client_ID=AD_PRINTFORMATITEM_TRL.AD_Client_ID AND IsMultiLingualDocument='N')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM_TRL SET PrintName = NULL WHERE PrintName IS NOT NULL AND EXISTS (SELECT 1 FROM AD_PRINTFORMATITEM pfi WHERE pfi.AD_PrintFormatItem_ID=AD_PRINTFORMATITEM_TRL.AD_PrintFormatItem_ID AND pfi.IsCentrallyMaintained='Y' AND (LENGTH (pfi.PrintName) = 0 OR pfi.PrintName IS NULL))
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU SET Name = (SELECT Name FROM AD_WINDOW w WHERE AD_MENU.AD_Window_ID=w.AD_Window_ID), Description = (SELECT Description FROM AD_WINDOW w WHERE AD_MENU.AD_Window_ID=w.AD_Window_ID) WHERE AD_MENU.AD_Window_ID IS NOT NULL AND AD_MENU."action" = 'W' AND AD_MENU.IsCentrallyMaintained='Y' AND AD_MENU.IsActive='Y'
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU_TRL SET Name = (SELECT wt.Name FROM AD_WINDOW_TRL wt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID AND AD_MENU_TRL.AD_LANGUAGE=wt.AD_LANGUAGE), Description = (SELECT wt.Description FROM AD_WINDOW_TRL wt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID AND AD_MENU_TRL.AD_LANGUAGE=wt.AD_LANGUAGE), IsTranslated = (SELECT wt.IsTranslated FROM AD_WINDOW_TRL wt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID AND AD_MENU_TRL.AD_LANGUAGE=wt.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_WINDOW_TRL wt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID AND AD_MENU_TRL.AD_LANGUAGE=wt.AD_LANGUAGE AND m.AD_Window_ID IS NOT NULL AND m."action" = 'W' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU SET Name = (SELECT p.Name FROM AD_PROCESS p WHERE AD_MENU.AD_Process_ID=p.AD_Process_ID), Description = (SELECT p.Description FROM AD_PROCESS p WHERE AD_MENU.AD_Process_ID=p.AD_Process_ID) WHERE AD_MENU.AD_Process_ID IS NOT NULL AND AD_MENU."action" IN ('R', 'P') AND AD_MENU.IsCentrallyMaintained='Y' AND AD_MENU.IsActive='Y'
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU_TRL SET Name = (SELECT pt.Name FROM AD_PROCESS_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE), Description = (SELECT pt.Description FROM AD_PROCESS_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE), IsTranslated = (SELECT pt.IsTranslated FROM AD_PROCESS_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_PROCESS_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE AND m.AD_Process_ID IS NOT NULL AND m."action" IN ('R', 'P') AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU SET Name = (SELECT Name FROM AD_FORM f WHERE AD_MENU.AD_Form_ID=f.AD_Form_ID), Description = (SELECT Description FROM AD_FORM f WHERE AD_MENU.AD_Form_ID=f.AD_Form_ID) WHERE AD_MENU.AD_Form_ID IS NOT NULL AND AD_MENU."action" = 'X' AND AD_MENU.IsCentrallyMaintained='Y' AND AD_MENU.IsActive='Y'
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU_TRL SET Name = (SELECT ft.Name FROM AD_FORM_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE), Description = (SELECT ft.Description FROM AD_FORM_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE), IsTranslated = (SELECT ft.IsTranslated FROM AD_FORM_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_FORM_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE AND m.AD_Form_ID IS NOT NULL AND m."action" = 'X' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU SET Name = (SELECT p.Name FROM AD_WORKFLOW p WHERE AD_MENU.AD_Workflow_ID=p.AD_Workflow_ID), Description = (SELECT p.Description FROM AD_WORKFLOW p WHERE AD_MENU.AD_Workflow_ID=p.AD_Workflow_ID) WHERE AD_MENU.AD_Workflow_ID IS NOT NULL AND AD_MENU."action" = 'F' AND AD_MENU.IsCentrallyMaintained='Y' AND AD_MENU.IsActive='Y'
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU_TRL SET Name = (SELECT pt.Name FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE), Description = (SELECT pt.Description FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE), IsTranslated = (SELECT pt.IsTranslated FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND AD_MENU_TRL.AD_LANGUAGE=pt.AD_LANGUAGE AND m.AD_Workflow_ID IS NOT NULL AND m."action" = 'F' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU SET Name = (SELECT Name FROM AD_TASK f WHERE AD_MENU.AD_Task_ID=f.AD_Task_ID), Description = (SELECT Description FROM AD_TASK f WHERE AD_MENU.AD_Task_ID=f.AD_Task_ID) WHERE AD_MENU.AD_Task_ID IS NOT NULL AND AD_MENU."action" = 'T' AND AD_MENU.IsCentrallyMaintained='Y' AND AD_MENU.IsActive='Y'
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_MENU_TRL SET Name = (SELECT ft.Name FROM AD_TASK_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE), Description = (SELECT ft.Description FROM AD_TASK_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE), IsTranslated = (SELECT ft.IsTranslated FROM AD_TASK_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_TASK_TRL ft, AD_MENU m WHERE AD_MENU_TRL.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND AD_MENU_TRL.AD_LANGUAGE=ft.AD_LANGUAGE AND m.AD_Task_ID IS NOT NULL AND m."action" = 'T' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_COLUMN SET Name=e.Name,Description=e.Description,Help=e.Help FROM AD_ELEMENT e WHERE AD_COLUMN.AD_Element_ID=e.AD_Element_ID AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE AD_COLUMN.AD_Element_ID=e.AD_Element_ID AND AD_COLUMN.Name<>e.Name)
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_COLUMN_TRL SET Name = (SELECT e.Name FROM AD_COLUMN c INNER JOIN AD_ELEMENT_TRL e ON (c.AD_Element_ID=e.AD_Element_ID) WHERE AD_COLUMN_TRL.AD_Column_ID=c.AD_Column_ID AND AD_COLUMN_TRL.AD_LANGUAGE=e.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_COLUMN c INNER JOIN AD_ELEMENT_TRL e ON (c.AD_Element_ID=e.AD_Element_ID) WHERE AD_COLUMN_TRL.AD_Column_ID=c.AD_Column_ID AND AD_COLUMN_TRL.AD_LANGUAGE=e.AD_LANGUAGE AND AD_COLUMN_TRL.Name<>e.Name)
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE SET Name=e.Name,Description=e.Description FROM AD_ELEMENT e WHERE AD_TABLE.TableName||'_ID'=e.ColumnName AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE AD_TABLE.TableName||'_ID'=e.ColumnName AND AD_TABLE.Name<>e.Name)
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE_TRL SET Name = (SELECT e.Name FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (t.TableName||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE AD_TABLE_TRL.AD_Table_ID=t.AD_Table_ID AND AD_TABLE_TRL.AD_LANGUAGE=e.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (t.TableName||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE AD_TABLE_TRL.AD_Table_ID=t.AD_Table_ID AND AD_TABLE_TRL.AD_LANGUAGE=e.AD_LANGUAGE AND AD_TABLE_TRL.Name<>e.Name)
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE SET Name=e.Name||' Trl',Description=e.Description FROM AD_ELEMENT e WHERE SUBSTR(AD_TABLE.TableName,1,LENGTH(AD_TABLE.TableName)-4)||'_ID'=e.ColumnName AND AD_TABLE.TableName LIKE '%_Trl' AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE SUBSTR(AD_TABLE.TableName,1,LENGTH(AD_TABLE.TableName)-4)||'_ID'=e.ColumnName AND AD_TABLE.Name<>e.Name)
;

-- Aug 29, 2014 5:34:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE_TRL SET Name = (SELECT e.Name || ' **' FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (SUBSTR(t.TableName,1,LENGTH(t.TableName)-4)||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE AD_TABLE_TRL.AD_Table_ID=t.AD_Table_ID AND AD_TABLE_TRL.AD_LANGUAGE=e.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (SUBSTR(t.TableName,1,LENGTH(t.TableName)-4)||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE AD_TABLE_TRL.AD_Table_ID=t.AD_Table_ID AND AD_TABLE_TRL.AD_LANGUAGE=e.AD_LANGUAGE AND t.TableName LIKE '%_Trl' AND AD_TABLE_TRL.Name<>e.Name)
;

