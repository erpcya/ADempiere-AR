-- Aug 29, 2014 5:30:26 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (AD_Client_ID,AD_Menu_ID,AD_Org_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES (0,1000000,0,TO_DATE('2014-08-29 17:30:25','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','Y','Attendance Record',TO_DATE('2014-08-29 17:30:25','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:30:26 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000000 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:30:26 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:30:26','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000000,0,999,TO_DATE('2014-08-29 17:30:26','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:30:38 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu_Trl SET IsTranslated='Y',Name='Registro de Asistencia',Updated=TO_DATE('2014-08-29 17:30:38','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=1000000 AND AD_Language='es_MX'
;

-- Aug 29, 2014 5:30:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000001,0,1000007,TO_DATE('2014-08-29 17:30:56','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Day',TO_DATE('2014-08-29 17:30:56','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:30:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000001 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:30:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:30:57','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000001,0,999,TO_DATE('2014-08-29 17:30:57','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:12 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000002,0,1000001,TO_DATE('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100,'U','Y','Y','N','N','N','Calendar',TO_DATE('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:12 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000002 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:31:13 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000002,0,999,TO_DATE('2014-08-29 17:31:12','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000003,0,1000010,TO_DATE('2014-08-29 17:31:28','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Journal',TO_DATE('2014-08-29 17:31:28','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000003 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:31:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:31:29','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000003,0,999,TO_DATE('2014-08-29 17:31:29','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:35 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Menu SET EntityType='ECA02',Updated=TO_DATE('2014-08-29 17:31:35','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Menu_ID=1000002
;

-- Aug 29, 2014 5:31:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000004,0,1000008,TO_DATE('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Journal Day',TO_DATE('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:31:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000004 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:31:51 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000004,0,999,TO_DATE('2014-08-29 17:31:50','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:15 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000005,0,1000009,TO_DATE('2014-08-29 17:32:14','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Attendance Record',TO_DATE('2014-08-29 17:32:14','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:15 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000005 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:32:15 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:32:15','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000005,0,999,TO_DATE('2014-08-29 17:32:15','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('W',0,1000006,0,1000003,TO_DATE('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Incidence Group',TO_DATE('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000006 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Aug 29, 2014 5:32:42 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000006,0,999,TO_DATE('2014-08-29 17:32:41','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=6,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=236
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=7,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=183
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=8,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=160
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=9,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=278
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=10,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=345
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=11,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=53014
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=12,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=53108
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=13,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000000
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=14,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=15,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=16,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=17,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=18,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:47 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=19,Updated=TO_DATE('2014-08-29 17:32:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000005
;

-- Aug 29, 2014 5:32:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=20,Updated=TO_DATE('2014-08-29 17:32:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000006
;

-- Aug 29, 2014 5:32:50 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-08-29 17:32:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:51 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-08-29 17:32:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:51 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-08-29 17:32:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:54 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-08-29 17:32:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:54 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-08-29 17:32:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:54 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-08-29 17:32:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:55 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-08-29 17:32:55','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:55 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_DATE('2014-08-29 17:32:55','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000005
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_DATE('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-08-29 17:32:57','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:32:58 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-08-29 17:32:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000006
;

-- Aug 29, 2014 5:32:58 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-08-29 17:32:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Aug 29, 2014 5:32:59 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_DATE('2014-08-29 17:32:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Aug 29, 2014 5:32:59 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-08-29 17:32:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:32:59 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=5,Updated=TO_DATE('2014-08-29 17:32:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:33:01 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=14,Updated=TO_DATE('2014-08-29 17:33:01','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:33:02 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-08-29 17:33:02','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:33:03 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-08-29 17:33:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

-- Aug 29, 2014 5:33:03 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=5,Updated=TO_DATE('2014-08-29 17:33:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Aug 29, 2014 5:33:03 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=6,Updated=TO_DATE('2014-08-29 17:33:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

