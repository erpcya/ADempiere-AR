-- Sep 1, 2014 10:12:39 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (AD_Client_ID,AD_Menu_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES (0,1000000,0,TO_DATE('2014-09-01 10:12:38','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','Y','Attendance Record',TO_DATE('2014-09-01 10:12:38','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:12:39 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000000 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:12:39 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:12:39','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000000,0,999,TO_DATE('2014-09-01 10:12:39','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:12:47 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET Name='Registro de Asistencia',Updated=TO_DATE('2014-09-01 10:12:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=1000000 AND AD_Language='es_MX'
;

-- Sep 1, 2014 10:14:16 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000001,0,1000009,TO_DATE('2014-09-01 10:14:15','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Attendance Record',TO_DATE('2014-09-01 10:14:15','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:14:16 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000001 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:14:16 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:14:16','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000001,0,999,TO_DATE('2014-09-01 10:14:16','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:14:18 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-09-01 10:14:18','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Sep 1, 2014 10:15:03 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000002,0,1000010,TO_DATE('2014-09-01 10:15:03','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Journal',TO_DATE('2014-09-01 10:15:03','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:15:03 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000002 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:15:03 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:15:03','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000002,0,999,TO_DATE('2014-09-01 10:15:03','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:15:06 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-09-01 10:15:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Sep 1, 2014 10:15:06 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-09-01 10:15:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Sep 1, 2014 10:16:49 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000003,0,1000010,TO_DATE('2014-09-01 10:16:48','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Journal',TO_DATE('2014-09-01 10:16:48','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:16:49 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000003 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:16:49 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:16:49','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000003,0,999,TO_DATE('2014-09-01 10:16:49','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:17:03 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET AD_Window_ID=1000008, Name='Journal Day',Updated=TO_DATE('2014-09-01 10:17:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=1000003
;

-- Sep 1, 2014 10:17:03 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='N' WHERE AD_Menu_ID=1000003
;

-- Sep 1, 2014 10:17:04 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-09-01 10:17:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Sep 1, 2014 10:17:04 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-09-01 10:17:04','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Sep 1, 2014 10:17:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000004,0,1000001,TO_DATE('2014-09-01 10:17:26','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Calendar',TO_DATE('2014-09-01 10:17:26','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:17:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000004 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:17:27 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:17:26','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000004,0,999,TO_DATE('2014-09-01 10:17:26','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:17:28 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-09-01 10:17:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Sep 1, 2014 10:17:28 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_DATE('2014-09-01 10:17:28','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Sep 1, 2014 10:20:33 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000005,0,1000003,TO_DATE('2014-09-01 10:20:33','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Incidence Group',TO_DATE('2014-09-01 10:20:33','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:20:33 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000005 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:20:33 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:20:33','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000005,0,999,TO_DATE('2014-09-01 10:20:33','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:20:35 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_DATE('2014-09-01 10:20:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000005
;

-- Sep 1, 2014 10:20:35 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-09-01 10:20:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Sep 1, 2014 10:20:49 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000006,0,1000007,TO_DATE('2014-09-01 10:20:48','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Day',TO_DATE('2014-09-01 10:20:48','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:20:49 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000006 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 1, 2014 10:20:49 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-01 10:20:49','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000006,0,999,TO_DATE('2014-09-01 10:20:49','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 1, 2014 10:20:51 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-09-01 10:20:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000006
;

-- Sep 1, 2014 10:20:51 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=5,Updated=TO_DATE('2014-09-01 10:20:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

