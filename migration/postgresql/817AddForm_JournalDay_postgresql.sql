-- Sep 29, 2014 2:09:58 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Form (AccessLevel,AD_Client_ID,AD_Form_ID,AD_Org_ID,Classname,Created,CreatedBy,EntityType,IsActive,IsBetaFunctionality,Name,Updated,UpdatedBy) VALUES ('3',0,1000000,0,'org.spin.form.VJournalDay',TO_TIMESTAMP('2014-09-29 14:09:57','YYYY-MM-DD HH24:MI:SS'),100,'ECA02','Y','N','Journal Day',TO_TIMESTAMP('2014-09-29 14:09:57','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Sep 29, 2014 2:09:58 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Form_Trl (AD_Language,AD_Form_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Form_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Form t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Form_ID=1000000 AND NOT EXISTS (SELECT * FROM AD_Form_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Form_ID=t.AD_Form_ID)
;

-- Sep 29, 2014 2:10:31 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Form_Trl SET Name='Jornadas del Día',Updated=TO_TIMESTAMP('2014-09-29 14:10:31','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Form_ID=1000000 AND AD_Language='es_MX'
;

