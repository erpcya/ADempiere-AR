-- Aug 28, 2014 2:32:43 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Window (AD_Client_ID,AD_Org_ID,AD_Window_ID,Created,CreatedBy,Description,EntityType,IsActive,IsBetaFunctionality,IsDefault,IsSOTrx,Name,Processing,Updated,UpdatedBy,WindowType,WinHeight,WinWidth) VALUES (0,0,1000006,TO_DATE('2014-08-28 14:32:42','YYYY-MM-DD HH24:MI:SS'),100,'Maintain Attendance Record','ECA02','Y','N','N','Y','Attendance Record','N',TO_DATE('2014-08-28 14:32:42','YYYY-MM-DD HH24:MI:SS'),100,'M',0,0)
;

-- Aug 28, 2014 2:32:43 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Window_Trl (AD_Language,AD_Window_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Window_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Window t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Window_ID=1000006 AND NOT EXISTS (SELECT * FROM AD_Window_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Window_ID=t.AD_Window_ID)
;

-- Aug 28, 2014 2:33:06 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Window_Trl SET IsTranslated='Y',Name='Registro de Asistencia',Description='Mantenimiendo de Registro de Asistencia',Updated=TO_DATE('2014-08-28 14:33:06','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Window_ID=1000006 AND AD_Language='es_MX'
;

-- Aug 28, 2014 2:33:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Tab (AD_Client_ID,AD_Org_ID,AD_Tab_ID,AD_Table_ID,AD_Window_ID,Created,CreatedBy,Description,EntityType,HasTree,ImportFields,IsActive,IsAdvancedTab,IsInfoTab,IsInsertRecord,IsReadOnly,IsSingleRow,IsSortTab,IsTranslationTab,Name,Processing,SeqNo,TabLevel,Updated,UpdatedBy) VALUES (0,0,1000008,1000005,1000006,TO_DATE('2014-08-28 14:33:56','YYYY-MM-DD HH24:MI:SS'),100,'Maintain Attendance Record','ECA02','N','N','Y','N','N','Y','N','N','N','N','Attendance Record','N',10,0,TO_DATE('2014-08-28 14:33:56','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:33:57 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Tab_Trl (AD_Language,AD_Tab_ID, CommitWarning,Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Tab_ID, t.CommitWarning,t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Tab t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Tab_ID=1000008 AND NOT EXISTS (SELECT * FROM AD_Tab_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Tab_ID=t.AD_Tab_ID)
;

-- Aug 28, 2014 2:34:07 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET IsSingleRow='Y',Updated=TO_DATE('2014-08-28 14:34:07','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=1000008
;

-- Aug 28, 2014 2:34:29 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab_Trl SET IsTranslated='Y',Name='Registro de Asistencia',Description='Mantenimiento de Registro de Asistencia',Updated=TO_DATE('2014-08-28 14:34:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=1000008 AND AD_Language='es_MX'
;

-- Aug 28, 2014 2:34:37 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,1000046,1000064,0,1000008,TO_DATE('2014-08-28 14:34:37','YYYY-MM-DD HH24:MI:SS'),100,'The record is active in the system',1,'ECA02','There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.','Y','Y','Y','N','N','N','N','N','Active',TO_DATE('2014-08-28 14:34:37','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:34:37 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=1000064 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Aug 28, 2014 2:34:38 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,1000051,1000065,0,1000008,TO_DATE('2014-08-28 14:34:37','YYYY-MM-DD HH24:MI:SS'),100,10,'ECA02','Y','Y','N','N','N','N','N','N','Attendance Record',TO_DATE('2014-08-28 14:34:37','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:34:38 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=1000065 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Aug 28, 2014 2:34:39 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,1000044,1000066,0,1000008,TO_DATE('2014-08-28 14:34:38','YYYY-MM-DD HH24:MI:SS'),100,'Client/Tenant for this installation.',22,'ECA02','A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.','Y','Y','Y','N','N','N','N','N','Client',TO_DATE('2014-08-28 14:34:38','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:34:39 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=1000066 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Aug 28, 2014 2:34:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,1000053,1000067,0,1000008,TO_DATE('2014-08-28 14:34:39','YYYY-MM-DD HH24:MI:SS'),100,7,'ECA02','Y','Y','Y','N','N','N','N','N','Date',TO_DATE('2014-08-28 14:34:39','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:34:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=1000067 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Aug 28, 2014 2:34:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,1000045,1000068,0,1000008,TO_DATE('2014-08-28 14:34:40','YYYY-MM-DD HH24:MI:SS'),100,'Organizational entity within client',22,'ECA02','An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.','Y','Y','Y','N','N','N','N','N','Organization',TO_DATE('2014-08-28 14:34:40','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:34:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=1000068 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Aug 28, 2014 2:34:42 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,1000052,1000069,0,1000008,TO_DATE('2014-08-28 14:34:41','YYYY-MM-DD HH24:MI:SS'),100,10,'ECA02','Y','Y','Y','N','N','N','N','N','Payroll Employee',TO_DATE('2014-08-28 14:34:41','YYYY-MM-DD HH24:MI:SS'),100)
;

-- Aug 28, 2014 2:34:42 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=1000069 AND NOT EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Field_ID=t.AD_Field_ID)
;

-- Aug 28, 2014 2:35:05 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=10,Updated=TO_DATE('2014-08-28 14:35:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000066
;

-- Aug 28, 2014 2:35:05 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=20,Updated=TO_DATE('2014-08-28 14:35:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000068
;

-- Aug 28, 2014 2:35:05 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=30,Updated=TO_DATE('2014-08-28 14:35:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000069
;

-- Aug 28, 2014 2:35:05 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=40,Updated=TO_DATE('2014-08-28 14:35:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000067
;

-- Aug 28, 2014 2:35:05 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=50,Updated=TO_DATE('2014-08-28 14:35:05','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000064
;

-- Aug 28, 2014 2:35:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=14,Updated=TO_DATE('2014-08-28 14:35:40','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000066
;

-- Aug 28, 2014 2:35:42 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=14,Updated=TO_DATE('2014-08-28 14:35:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000068
;

-- Aug 28, 2014 2:35:44 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET DisplayLength=14,Updated=TO_DATE('2014-08-28 14:35:44','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000069
;

-- Aug 28, 2014 2:35:48 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-08-28 14:35:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000068
;

-- Aug 28, 2014 2:36:02 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_DATE('2014-08-28 14:36:02','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000067
;

-- Aug 28, 2014 2:36:14 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET IsTranslated='Y',Name='Fecha',Updated=TO_DATE('2014-08-28 14:36:14','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000067 AND AD_Language='es_MX'
;

-- Aug 28, 2014 2:36:56 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET Name='Activo',Updated=TO_DATE('2014-08-28 14:36:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000064 AND AD_Language='es_MX'
;

-- Aug 28, 2014 2:37:21 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Field_Trl SET Name='Compañía''j,8mp8ki,9.ki9,ki9,ki',Updated=TO_DATE('2014-08-28 14:37:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1000001 AND AD_Language='es_MX'
;

-- 28/08/2014 02:56:39 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_ELEMENT_TRL (AD_Element_ID, AD_LANGUAGE, AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy, Name, PrintName, Description, Help, IsTranslated) SELECT m.AD_Element_ID, l.AD_LANGUAGE, m.AD_Client_ID, m.AD_Org_ID, m.IsActive, m.Created, m.CreatedBy, m.Updated, m.UpdatedBy, m.Name, m.PrintName, m.Description, m.Help, 'N' FROM	AD_ELEMENT m, AD_LANGUAGE l WHERE	l.IsActive = 'Y' AND l.IsSystemLanguage = 'Y' AND	AD_Element_ID || AD_LANGUAGE NOT IN  (SELECT AD_Element_ID || AD_LANGUAGE FROM AD_ELEMENT_TRL)
;

-- 28/08/2014 02:56:39 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_COLUMN c SET		AD_Element_id = 	(SELECT AD_Element_ID FROM AD_ELEMENT e 	WHERE UPPER(c.ColumnName)=UPPER(e.ColumnName)) 	WHERE AD_Element_ID IS NULL
;

-- 28/08/2014 02:56:39 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE	AD_ELEMENT_TRL 	WHERE	AD_Element_ID IN 	(SELECT AD_Element_ID FROM AD_ELEMENT e  	WHERE NOT EXISTS 	(SELECT 1 FROM AD_COLUMN c WHERE UPPER(e.ColumnName)=UPPER(c.ColumnName)) 	AND NOT EXISTS 	(SELECT 1 FROM AD_PROCESS_PARA p WHERE UPPER(e.ColumnName)=UPPER(p.ColumnName)))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
DELETE	AD_ELEMENT e 	WHERE AD_Element_ID >= 1000000 AND NOT EXISTS 	(SELECT 1 FROM AD_COLUMN c WHERE UPPER(e.ColumnName)=UPPER(c.ColumnName)) 	AND NOT EXISTS 	(SELECT 1 FROM AD_PROCESS_PARA p WHERE UPPER(e.ColumnName)=UPPER(p.ColumnName))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
 	UPDATE AD_COLUMN c 		SET	(ColumnName, Name, Description, Help) = 	           (SELECT ColumnName, Name, Description, Help 	            FROM AD_ELEMENT e WHERE c.AD_Element_ID=e.AD_Element_ID), 			Updated = SYSDATE 	WHERE EXISTS (SELECT 1 FROM AD_ELEMENT e  				WHERE c.AD_Element_ID=e.AD_Element_ID 				  AND (c.ColumnName <> e.ColumnName OR c.Name <> e.Name  					OR NVL(c.Description,' ') <> NVL(e.Description,' ') OR NVL(c.Help,' ') <> NVL(e.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
 	UPDATE AD_FIELD f 		SET (Name, Description, Help) =  	            (SELECT e.Name, e.Description, e.Help 	            FROM AD_ELEMENT e, AD_COLUMN c 	    	    WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID), 			Updated = SYSDATE 	WHERE f.IsCentrallyMaintained='Y' AND f.IsActive='Y' 	 AND EXISTS (SELECT 1 FROM AD_ELEMENT e, AD_COLUMN c 				WHERE f.AD_Column_ID=c.AD_Column_ID 				  AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL 				  AND (f.Name <> e.Name OR NVL(f.Description,' ') <> NVL(e.Description,' ') OR NVL(f.Help,' ') <> NVL(e.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD_TRL trl SET Name = (SELECT e.Name FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID 			  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID),	Description = (SELECT e.Description FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID 			  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID),	Help = (SELECT e.Help FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID 			  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID),	IsTranslated = (SELECT e.IsTranslated FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID 			  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID),	Updated = SYSDATE WHERE EXISTS (SELECT 1 FROM AD_FIELD f, AD_ELEMENT_TRL e, AD_COLUMN c		WHERE trl.AD_Field_ID=f.AD_Field_ID		  AND f.AD_Column_ID=c.AD_Column_ID		  AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL		  AND trl.AD_LANGUAGE=e.AD_LANGUAGE		  AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y'		  AND (trl.Name <> e.Name OR NVL(trl.Description,' ') <> NVL(e.Description,' ') OR NVL(trl.Help,' ') <> NVL(e.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD f SET Name = (SELECT e.PO_Name FROM AD_ELEMENT e, AD_COLUMN c 			WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID), 	Description = (SELECT e.PO_Description FROM AD_ELEMENT e, AD_COLUMN c 			WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID), 	Help = (SELECT e.PO_Help FROM AD_ELEMENT e, AD_COLUMN c 			WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=f.AD_Column_ID), 	Updated = SYSDATE WHERE f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e, AD_COLUMN c 		WHERE f.AD_Column_ID=c.AD_Column_ID 		  AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL 		  AND (f.Name <> e.PO_Name OR NVL(f.Description,' ') <> NVL(e.PO_Description,' ') OR NVL(f.Help,' ') <> NVL(e.PO_Help,' ')) 		  AND e.PO_Name IS NOT NULL) AND EXISTS (SELECT 1 FROM AD_TAB t, AD_WINDOW w 		WHERE f.AD_Tab_ID=t.AD_Tab_ID 		  AND t.AD_Window_ID=w.AD_Window_ID 		  AND w.IsSOTrx='N')
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
 UPDATE AD_FIELD_TRL trl SET Name = (SELECT e.PO_Name FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f 		WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID 		  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID), Description = (SELECT e.PO_Description FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f 		WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID  		  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID), Help = (SELECT e.PO_Help FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f 		WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID 		  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID), IsTranslated = (SELECT e.IsTranslated FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_FIELD f 		WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID  		  AND c.AD_Column_ID=f.AD_Column_ID AND f.AD_Field_ID=trl.AD_Field_ID), Updated = SYSDATE WHERE EXISTS (SELECT 1 FROM AD_FIELD f, AD_ELEMENT_TRL e, AD_COLUMN c 	WHERE trl.AD_Field_ID=f.AD_Field_ID 	  AND f.AD_Column_ID=c.AD_Column_ID 	  AND c.AD_Element_ID=e.AD_Element_ID AND c.AD_Process_ID IS NULL 	  AND trl.AD_LANGUAGE=e.AD_LANGUAGE 	  AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' 	  AND (trl.Name <> e.PO_Name OR NVL(trl.Description,' ') <> NVL(e.PO_Description,' ') OR NVL(trl.Help,' ') <> NVL(e.PO_Help,' ')) 	  AND e.PO_Name IS NOT NULL) AND EXISTS (SELECT 1 FROM AD_FIELD f, AD_TAB t, AD_WINDOW w 	WHERE trl.AD_Field_ID=f.AD_Field_ID 	  AND f.AD_Tab_ID=t.AD_Tab_ID 	  AND t.AD_Window_ID=w.AD_Window_ID 	  AND w.IsSOTrx='N')
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD f SET Name = (SELECT p.Name FROM AD_PROCESS p, AD_COLUMN c WHERE p.AD_Process_ID=c.AD_Process_ID 			AND c.AD_Column_ID=f.AD_Column_ID), 	Description = (SELECT p.Description FROM AD_PROCESS p, AD_COLUMN c WHERE p.AD_Process_ID=c.AD_Process_ID 			AND c.AD_Column_ID=f.AD_Column_ID), 	Help = (SELECT p.Help FROM AD_PROCESS p, AD_COLUMN c WHERE p.AD_Process_ID=c.AD_Process_ID 			AND c.AD_Column_ID=f.AD_Column_ID), 	Updated = SYSDATE WHERE f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_PROCESS p, AD_COLUMN c 		WHERE c.AD_Process_ID=p.AD_Process_ID AND f.AD_Column_ID=c.AD_Column_ID 		AND (f.Name<>p.Name OR NVL(f.Description,' ')<>NVL(p.Description,' ') OR NVL(f.Help,' ')<>NVL(p.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_FIELD_TRL trl SET Name = (SELECT p.Name FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f 			WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID 			AND f.AD_Field_ID=trl.AD_Field_ID AND p.AD_LANGUAGE=trl.AD_LANGUAGE), 	Description = (SELECT p.Description FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f 			WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID 			AND f.AD_Field_ID=trl.AD_Field_ID AND p.AD_LANGUAGE=trl.AD_LANGUAGE), 	Help = (SELECT p.Help FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f  			WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID 			AND f.AD_Field_ID=trl.AD_Field_ID AND p.AD_LANGUAGE=trl.AD_LANGUAGE), 	IsTranslated = (SELECT p.IsTranslated FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f 			WHERE p.AD_Process_ID=c.AD_Process_ID AND c.AD_Column_ID=f.AD_Column_ID 			AND f.AD_Field_ID=trl.AD_Field_ID AND p.AD_LANGUAGE=trl.AD_LANGUAGE), 	Updated = SYSDATE WHERE EXISTS (SELECT 1 FROM AD_PROCESS_TRL p, AD_COLUMN c, AD_FIELD f 		WHERE c.AD_Process_ID=p.AD_Process_ID AND f.AD_Column_ID=c.AD_Column_ID 		AND f.AD_Field_ID=trl.AD_Field_ID AND p.AD_LANGUAGE=trl.AD_LANGUAGE 		AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' 		AND (trl.Name<>p.Name OR NVL(trl.Description,' ')<>NVL(p.Description,' ') OR NVL(trl.Help,' ')<>NVL(p.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
 	UPDATE AD_BROWSE_FIELD f 		SET (Name, Description, Help) =  	            (SELECT e.Name, e.Description, e.Help 	            FROM AD_ELEMENT e  	    	    WHERE e.AD_Element_ID=f.AD_Element_ID), 			Updated = SYSDATE 	WHERE f.IsCentrallyMaintained='Y' AND f.IsActive='Y' 	 AND EXISTS (SELECT 1 FROM AD_ELEMENT e  				  WHERE f.AD_Element_ID=e.AD_Element_ID  				  AND (f.Name <> e.Name OR NVL(f.Description,' ') <> NVL(e.Description,' ') OR NVL(f.Help,' ') <> NVL(e.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_BROWSE_FIELD_TRL trl SET Name = (SELECT e.Name FROM AD_ELEMENT_TRL e , AD_BROWSE_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID 			 AND f.AD_Browse_Field_ID=trl.AD_Browse_Field_ID),	Description = (SELECT e.Description FROM AD_ELEMENT_TRL e, AD_BROWSE_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID 			 AND f.AD_Browse_Field_ID=trl.AD_Browse_Field_ID),	Help = (SELECT e.Help FROM AD_ELEMENT_TRL e, AD_BROWSE_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID 			 AND f.AD_Browse_Field_ID=trl.AD_Browse_Field_ID),	IsTranslated = (SELECT e.IsTranslated FROM AD_ELEMENT_TRL e, AD_BROWSE_FIELD f			WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=f.AD_Element_ID 			  AND f.AD_Browse_Field_ID=trl.AD_Browse_Field_ID),	Updated = SYSDATE WHERE EXISTS (SELECT 1 FROM AD_BROWSE_FIELD f, AD_ELEMENT_TRL e		WHERE trl.AD_Browse_Field_ID=f.AD_Browse_Field_ID		  AND f.AD_Element_ID=e.AD_Element_ID		  AND trl.AD_LANGUAGE=e.AD_LANGUAGE		  AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y'		  AND (trl.Name <> e.Name OR NVL(trl.Description,' ') <> NVL(e.Description,' ') OR NVL(trl.Help,' ') <> NVL(e.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_PROCESS_PARA f SET	ColumnName = (SELECT e.ColumnName FROM AD_ELEMENT e 			WHERE UPPER(e.ColumnName)=UPPER(f.ColumnName)) WHERE f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE UPPER(e.ColumnName)=UPPER(f.ColumnName) AND e.ColumnName<>f.ColumnName)
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_PROCESS_PARA p SET	IsCentrallyMaintained = 'N' WHERE	IsCentrallyMaintained <> 'N' AND NOT EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE p.ColumnName=e.ColumnName)
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PROCESS_PARA f SET Name = (SELECT e.Name FROM AD_ELEMENT e 			WHERE e.ColumnName=f.ColumnName), 	Description = (SELECT e.Description FROM AD_ELEMENT e 			WHERE e.ColumnName=f.ColumnName), 	Help = (SELECT e.Help FROM AD_ELEMENT e 			WHERE e.ColumnName=f.ColumnName), 	Updated = SYSDATE WHERE f.IsCentrallyMaintained='Y' AND f.IsActive='Y' AND EXISTS (SELECT 1 FROM AD_ELEMENT e 		WHERE e.ColumnName=f.ColumnName 		  AND (f.Name <> e.Name OR NVL(f.Description,' ') <> NVL(e.Description,' ') OR NVL(f.Help,' ') <> NVL(e.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PROCESS_PARA_TRL trl SET Name = (SELECT et.Name FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f 			WHERE et.AD_LANGUAGE=trl.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID 			  AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=trl.AD_Process_Para_ID), 	Description = (SELECT et.Description FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f 			WHERE et.AD_LANGUAGE=trl.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID 			  AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=trl.AD_Process_Para_ID), 	Help = (SELECT et.Help FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f 			WHERE et.AD_LANGUAGE=trl.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID 			  AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=trl.AD_Process_Para_ID), 	IsTranslated = (SELECT et.IsTranslated FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f 			WHERE et.AD_LANGUAGE=trl.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID 			  AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=trl.AD_Process_Para_ID), 	Updated = SYSDATE WHERE EXISTS (SELECT 1 FROM AD_ELEMENT_TRL et, AD_ELEMENT e, AD_PROCESS_PARA f 			WHERE et.AD_LANGUAGE=trl.AD_LANGUAGE AND et.AD_Element_ID=e.AD_Element_ID 			  AND e.ColumnName=f.ColumnName AND f.AD_Process_Para_ID=trl.AD_Process_Para_ID 			  AND f.IsCentrallyMaintained='Y' AND f.IsActive='Y' 			  AND (trl.Name <> et.Name OR NVL(trl.Description,' ') <> NVL(et.Description,' ') OR NVL(trl.Help,' ') <> NVL(et.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE n SET Name = (SELECT w.Name FROM AD_WINDOW w 			WHERE w.AD_Window_ID=n.AD_Window_ID), 	Description = (SELECT w.Description FROM AD_WINDOW w 			WHERE w.AD_Window_ID=n.AD_Window_ID), 	Help = (SELECT w.Help FROM AD_WINDOW w 			WHERE w.AD_Window_ID=n.AD_Window_ID) WHERE n.IsCentrallyMaintained = 'Y'  AND EXISTS  (SELECT 1 FROM AD_WINDOW w 		WHERE w.AD_Window_ID=n.AD_Window_ID 		  AND (w.Name <> n.Name OR NVL(w.Description,' ') <> NVL(n.Description,' ') OR NVL(w.Help,' ') <> NVL(n.Help,' ')))
;

-- 28/08/2014 02:56:40 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE_TRL trl SET Name = (SELECT t.Name FROM AD_WINDOW_TRL t, AD_WF_NODE n 			WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID 			  AND trl.AD_LANGUAGE=t.AD_LANGUAGE), 	Description = (SELECT t.Description FROM AD_WINDOW_TRL t, AD_WF_NODE n 			WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID 			  AND trl.AD_LANGUAGE=t.AD_LANGUAGE), 	Help = (SELECT t.Help FROM AD_WINDOW_TRL t, AD_WF_NODE n 			WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID 			  AND trl.AD_LANGUAGE=t.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_WINDOW_TRL t, AD_WF_NODE n 		WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Window_ID=t.AD_Window_ID 		  AND trl.AD_LANGUAGE=t.AD_LANGUAGE AND n.IsCentrallyMaintained='Y' AND n.IsActive='Y' 		  AND (trl.Name <> t.Name OR NVL(trl.Description,' ') <> NVL(t.Description,' ') OR NVL(trl.Help,' ') <> NVL(t.Help,' ')))
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE n SET (Name, Description, Help) = (SELECT f.Name, f.Description, f.Help 		FROM AD_FORM f 		WHERE f.AD_Form_ID=n.AD_Form_ID) WHERE n.IsCentrallyMaintained = 'Y' AND EXISTS  (SELECT 1 FROM AD_FORM f 		WHERE f.AD_Form_ID=n.AD_Form_ID 		  AND (f.Name <> n.Name OR NVL(f.Description,' ') <> NVL(n.Description,' ') OR NVL(f.Help,' ') <> NVL(n.Help,' ')))
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
 UPDATE AD_WF_NODE_TRL trl SET (Name, Description, Help) = (SELECT t.Name, t.Description, t.Help 	FROM AD_FORM_TRL t, AD_WF_NODE n 	WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Form_ID=t.AD_Form_ID 	  AND trl.AD_LANGUAGE=t.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_FORM_TRL t, AD_WF_NODE n 		WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Form_ID=t.AD_Form_ID 		  AND trl.AD_LANGUAGE=t.AD_LANGUAGE AND n.IsCentrallyMaintained='Y' AND n.IsActive='Y' 		  AND (trl.Name <> t.Name OR NVL(trl.Description,' ') <> NVL(t.Description,' ') OR NVL(trl.Help,' ') <> NVL(t.Help,' ')))
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE n SET (Name, Description, Help) = (SELECT f.Name, f.Description, f.Help 		FROM AD_PROCESS f 		WHERE f.AD_Process_ID=n.AD_Process_ID) WHERE n.IsCentrallyMaintained = 'Y' AND EXISTS  (SELECT 1 FROM AD_PROCESS f 		WHERE f.AD_Process_ID=n.AD_Process_ID 		  AND (f.Name <> n.Name OR NVL(f.Description,' ') <> NVL(n.Description,' ') OR NVL(f.Help,' ') <> NVL(n.Help,' ')))
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_WF_NODE_TRL trl SET (Name, Description, Help) = (SELECT t.Name, t.Description, t.Help FROM AD_PROCESS_TRL t, AD_WF_NODE n WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Process_ID=t.AD_Process_ID  AND trl.AD_LANGUAGE=t.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_PROCESS_TRL t, AD_WF_NODE n WHERE trl.AD_WF_Node_ID=n.AD_WF_Node_ID AND n.AD_Process_ID=t.AD_Process_ID  AND trl.AD_LANGUAGE=t.AD_LANGUAGE AND n.IsCentrallyMaintained='Y' AND n.IsActive='Y'  AND (trl.Name <> t.Name OR NVL(trl.Description,' ') <> NVL(t.Description,' ') OR NVL(trl.Help,' ') <> NVL(t.Help,' ')))
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM pfi SET Name = (SELECT e.Name  FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID) WHERE pfi.IsCentrallyMaintained='Y' AND EXISTS (SELECT 1  FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID AND e.Name<>pfi.Name) AND EXISTS (SELECT 1 FROM AD_CLIENT WHERE AD_Client_ID=pfi.AD_Client_ID AND IsMultiLingualDocument='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM pfi SET PrintName = (SELECT e.PrintName  FROM AD_ELEMENT e, AD_COLUMN c WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID) WHERE pfi.IsCentrallyMaintained='Y' AND EXISTS (SELECT 1  FROM AD_ELEMENT e, AD_COLUMN c, AD_PRINTFORMAT pf WHERE e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID AND LENGTH(pfi.PrintName) > 0 AND e.PrintName<>pfi.PrintName AND pf.AD_PrintFormat_ID=pfi.AD_PrintFormat_ID AND pf.IsForm='N' AND IsTableBased='Y') AND EXISTS (SELECT 1 FROM AD_CLIENT  WHERE AD_Client_ID=pfi.AD_Client_ID AND IsMultiLingualDocument='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM_TRL trl SET PrintName = (SELECT e.PrintName FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_PRINTFORMATITEM pfi WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID AND pfi.AD_PrintFormatItem_ID=trl.AD_PrintFormatItem_ID) WHERE EXISTS (SELECT 1  FROM AD_ELEMENT_TRL e, AD_COLUMN c, AD_PRINTFORMATITEM pfi, AD_PRINTFORMAT pf WHERE e.AD_LANGUAGE=trl.AD_LANGUAGE AND e.AD_Element_ID=c.AD_Element_ID AND c.AD_Column_ID=pfi.AD_Column_ID AND pfi.AD_PrintFormatItem_ID=trl.AD_PrintFormatItem_ID AND pfi.IsCentrallyMaintained='Y' AND LENGTH(pfi.PrintName) > 0 AND (e.PrintName<>trl.PrintName OR trl.PrintName IS NULL) AND pf.AD_PrintFormat_ID=pfi.AD_PrintFormat_ID  AND pf.IsForm='N' AND IsTableBased='Y') AND EXISTS (SELECT 1 FROM AD_CLIENT  WHERE AD_Client_ID=trl.AD_Client_ID AND IsMultiLingualDocument='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM_TRL trl SET PrintName = (SELECT pfi.PrintName FROM AD_PRINTFORMATITEM pfi WHERE pfi.AD_PrintFormatItem_ID=trl.AD_PrintFormatItem_ID) WHERE EXISTS (SELECT 1  FROM AD_PRINTFORMATITEM pfi, AD_PRINTFORMAT pf WHERE pfi.AD_PrintFormatItem_ID=trl.AD_PrintFormatItem_ID AND pfi.IsCentrallyMaintained='Y' AND LENGTH(pfi.PrintName) > 0 AND pfi.PrintName<>trl.PrintName AND pf.AD_PrintFormat_ID=pfi.AD_PrintFormat_ID  AND pf.IsForm='N' AND pf.IsTableBased='Y') AND EXISTS (SELECT 1 FROM AD_CLIENT  WHERE AD_Client_ID=trl.AD_Client_ID AND IsMultiLingualDocument='N')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_PRINTFORMATITEM_TRL trl SET PrintName = NULL WHERE PrintName IS NOT NULL AND EXISTS (SELECT 1 FROM AD_PRINTFORMATITEM pfi WHERE pfi.AD_PrintFormatItem_ID=trl.AD_PrintFormatItem_ID AND pfi.IsCentrallyMaintained='Y' AND (LENGTH (pfi.PrintName) = 0 OR pfi.PrintName IS NULL))
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU m SET		Name = (SELECT Name FROM AD_WINDOW w WHERE m.AD_Window_ID=w.AD_Window_ID), Description = (SELECT Description FROM AD_WINDOW w WHERE m.AD_Window_ID=w.AD_Window_ID) WHERE	m.AD_Window_ID IS NOT NULL  AND m.Action = 'W'  AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y'
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU_TRL mt SET		Name = (SELECT wt.Name FROM AD_WINDOW_TRL wt, AD_MENU m  WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID  AND mt.AD_LANGUAGE=wt.AD_LANGUAGE), Description = (SELECT wt.Description FROM AD_WINDOW_TRL wt, AD_MENU m  WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID  AND mt.AD_LANGUAGE=wt.AD_LANGUAGE), IsTranslated = (SELECT wt.IsTranslated FROM AD_WINDOW_TRL wt, AD_MENU m  WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID  AND mt.AD_LANGUAGE=wt.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_WINDOW_TRL wt, AD_MENU m  WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Window_ID=wt.AD_Window_ID  AND mt.AD_LANGUAGE=wt.AD_LANGUAGE AND m.AD_Window_ID IS NOT NULL AND m.Action = 'W' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU m SET		Name = (SELECT p.Name FROM AD_PROCESS p WHERE m.AD_Process_ID=p.AD_Process_ID), Description = (SELECT p.Description FROM AD_PROCESS p WHERE m.AD_Process_ID=p.AD_Process_ID) WHERE m.AD_Process_ID IS NOT NULL AND m.Action IN ('R', 'P') AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y'
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU_TRL mt SET		Name = (SELECT pt.Name FROM AD_PROCESS_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE), Description = (SELECT pt.Description FROM AD_PROCESS_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE), IsTranslated = (SELECT pt.IsTranslated FROM AD_PROCESS_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_PROCESS_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Process_ID=pt.AD_Process_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE AND m.AD_Process_ID IS NOT NULL AND m.Action IN ('R', 'P') AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU m SET		Name = (SELECT Name FROM AD_FORM f WHERE m.AD_Form_ID=f.AD_Form_ID), Description = (SELECT Description FROM AD_FORM f WHERE m.AD_Form_ID=f.AD_Form_ID) WHERE m.AD_Form_ID IS NOT NULL AND m.Action = 'X' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y'
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU_TRL mt SET		Name = (SELECT ft.Name FROM AD_FORM_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE), Description = (SELECT ft.Description FROM AD_FORM_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE), IsTranslated = (SELECT ft.IsTranslated FROM AD_FORM_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_FORM_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Form_ID=ft.AD_Form_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE AND m.AD_Form_ID IS NOT NULL AND m.Action = 'X' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU m SET		Name = (SELECT p.Name FROM AD_WORKFLOW p WHERE m.AD_Workflow_ID=p.AD_Workflow_ID), Description = (SELECT p.Description FROM AD_WORKFLOW p WHERE m.AD_Workflow_ID=p.AD_Workflow_ID) WHERE m.AD_Workflow_ID IS NOT NULL AND m.Action = 'F' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y'
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU_TRL mt SET		Name = (SELECT pt.Name FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE), Description = (SELECT pt.Description FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE), IsTranslated = (SELECT pt.IsTranslated FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_WORKFLOW_TRL pt, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Workflow_ID=pt.AD_Workflow_ID AND mt.AD_LANGUAGE=pt.AD_LANGUAGE AND m.AD_Workflow_ID IS NOT NULL AND m.Action = 'F' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU m SET		Name = (SELECT Name FROM AD_TASK f WHERE m.AD_Task_ID=f.AD_Task_ID), Description = (SELECT Description FROM AD_TASK f WHERE m.AD_Task_ID=f.AD_Task_ID) WHERE m.AD_Task_ID IS NOT NULL AND m.Action = 'T' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y'
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE	AD_MENU_TRL mt SET		Name = (SELECT ft.Name FROM AD_TASK_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE), Description = (SELECT ft.Description FROM AD_TASK_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE), IsTranslated = (SELECT ft.IsTranslated FROM AD_TASK_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE) WHERE EXISTS (SELECT 1 FROM AD_TASK_TRL ft, AD_MENU m WHERE mt.AD_Menu_ID=m.AD_Menu_ID AND m.AD_Task_ID=ft.AD_Task_ID AND mt.AD_LANGUAGE=ft.AD_LANGUAGE AND m.AD_Task_ID IS NOT NULL AND m.Action = 'T' AND m.IsCentrallyMaintained='Y' AND m.IsActive='Y')
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_COLUMN c SET (Name,Description,Help) = (SELECT e.Name,e.Description,e.Help  FROM AD_ELEMENT e WHERE c.AD_Element_ID=e.AD_Element_ID) WHERE EXISTS  (SELECT 1 FROM AD_ELEMENT e  WHERE c.AD_Element_ID=e.AD_Element_ID AND c.Name<>e.Name)
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_COLUMN_TRL ct SET Name = (SELECT e.Name FROM AD_COLUMN c INNER JOIN AD_ELEMENT_TRL e ON (c.AD_Element_ID=e.AD_Element_ID) WHERE ct.AD_Column_ID=c.AD_Column_ID AND ct.AD_LANGUAGE=e.AD_LANGUAGE) WHERE EXISTS  (SELECT 1 FROM AD_COLUMN c INNER JOIN AD_ELEMENT_TRL e ON (c.AD_Element_ID=e.AD_Element_ID) WHERE ct.AD_Column_ID=c.AD_Column_ID AND ct.AD_LANGUAGE=e.AD_LANGUAGE AND ct.Name<>e.Name)
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE t SET (Name,Description) = (SELECT e.Name,e.Description FROM AD_ELEMENT e WHERE t.TableName||'_ID'=e.ColumnName) WHERE EXISTS (SELECT 1 FROM AD_ELEMENT e WHERE t.TableName||'_ID'=e.ColumnName AND t.Name<>e.Name)
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE_TRL tt SET Name = (SELECT e.Name  FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (t.TableName||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE tt.AD_Table_ID=t.AD_Table_ID AND tt.AD_LANGUAGE=e.AD_LANGUAGE) WHERE EXISTS (SELECT 1  FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (t.TableName||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE tt.AD_Table_ID=t.AD_Table_ID AND tt.AD_LANGUAGE=e.AD_LANGUAGE AND tt.Name<>e.Name)
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_TABLE t SET (Name,Description) = (SELECT e.Name||' Trl', e.Description  FROM AD_ELEMENT e  WHERE SUBSTR(t.TableName,1,LENGTH(t.TableName)-4)||'_ID'=e.ColumnName) WHERE TableName LIKE '%_Trl' AND EXISTS (SELECT 1 FROM AD_ELEMENT e  WHERE SUBSTR(t.TableName,1,LENGTH(t.TableName)-4)||'_ID'=e.ColumnName AND t.Name<>e.Name)
;

-- 28/08/2014 02:56:41 PM VET
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
 UPDATE AD_TABLE_TRL tt SET Name = (SELECT e.Name || ' **' FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (SUBSTR(t.TableName,1,LENGTH(t.TableName)-4)||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE tt.AD_Table_ID=t.AD_Table_ID AND tt.AD_LANGUAGE=e.AD_LANGUAGE) WHERE EXISTS (SELECT 1  FROM AD_TABLE t INNER JOIN AD_ELEMENT ex ON (SUBSTR(t.TableName,1,LENGTH(t.TableName)-4)||'_ID'=ex.ColumnName) INNER JOIN AD_ELEMENT_TRL e ON (ex.AD_Element_ID=e.AD_Element_ID) WHERE tt.AD_Table_ID=t.AD_Table_ID AND tt.AD_LANGUAGE=e.AD_LANGUAGE AND t.TableName LIKE '%_Trl' AND tt.Name<>e.Name)
;

