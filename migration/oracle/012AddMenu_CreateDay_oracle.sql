-- Sep 4, 2014 9:12:47 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Process_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('P',0,1000000,0,1000000,TO_DATE('2014-09-04 09:12:46','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Create Day',TO_DATE('2014-09-04 09:12:46','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 4, 2014 9:13:23 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu (Action,AD_Client_ID,AD_Menu_ID,AD_Org_ID,AD_Process_ID,Created,CreatedBy,EntityType,IsActive,IsCentrallyMaintained,IsReadOnly,IsSOTrx,IsSummary,Name,Updated,UpdatedBy) VALUES ('P',0,1000007,0,1000000,TO_DATE('2014-09-04 09:13:22','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','Y','N','N','N','Create Day',TO_DATE('2014-09-04 09:13:22','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 4, 2014 9:13:23 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=1000007 AND NOT EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Menu_ID=t.AD_Menu_ID)
;

-- Sep 4, 2014 9:13:23 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID,AD_Tree_ID,Created,CreatedBy,IsActive,Node_ID,Parent_ID,SeqNo,Updated,UpdatedBy) VALUES (0,0,10,TO_DATE('2014-09-04 09:13:23','YYYY-MM-DD HH24:MI:SS'),100,'Y',1000007,0,999,TO_DATE('2014-09-04 09:13:23','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 4, 2014 9:13:25 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=0,Updated=TO_DATE('2014-09-04 09:13:25','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000007
;

-- Sep 4, 2014 9:13:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=1,Updated=TO_DATE('2014-09-04 09:13:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000002
;

-- Sep 4, 2014 9:13:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=2,Updated=TO_DATE('2014-09-04 09:13:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000003
;

-- Sep 4, 2014 9:13:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=3,Updated=TO_DATE('2014-09-04 09:13:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000004
;

-- Sep 4, 2014 9:13:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=4,Updated=TO_DATE('2014-09-04 09:13:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000005
;

-- Sep 4, 2014 9:13:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=5,Updated=TO_DATE('2014-09-04 09:13:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000006
;

-- Sep 4, 2014 9:13:26 AM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TreeNodeMM SET Parent_ID=1000000, SeqNo=6,Updated=TO_DATE('2014-09-04 09:13:26','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tree_ID=10 AND Node_ID=1000001
;

