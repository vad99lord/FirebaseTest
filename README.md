## Firebase AppDistribution error showcase 
### Error: appId overriden when using two build types and kotlin build.gradle file.

### Steps to reproduce:

1. Set correct package name, applicationId. Set **appId** in **build.gradle.kts**  **firebaseAppDistribution** block to match your firebase console project release and debug ids.

2. Login with `gradlew appDistributionLogin`, set **FIREBASE_TOKEN** terminal variable.

3. Use **build.gradle.kts** file for build

4. Run `gradlew assembleRelease appDistributionUploadRelease`. Verify distribution error:

   ```
   App Distribution failed to process the APK: There's been an error processing your upload. 
   The APK package name 'com.example.yourapp' does not match your Firebase app's package name 'com.example.yourapp.debug'. 
   Change the APK package name to 'com.example.yourapp.debug' and retry the upload. 
   If a Firebase app already exists for 'com.example.yourapp', upload your APK to that Firebase app instead.
   ```

5. Run `gradlew assembleDebug appDistributionUploadDebug`. Verify successful distribution. 

6. Swap release and debug blocks in **build.gradle.kts**. Run steps 4-5. Verify that error now occurs in debug build:

   ```
   App Distribution failed to process the APK: There's been an error processing your upload. 
   The APK package name 'com.example.yourapp.debug' does not match your Firebase app's package name 'com.example.yourapp'. 
   Change the APK package name to 'com.example.yourapp' and retry the upload.  
   If a Firebase app already exists for 'com.example.yourapp.debug', upload your APK to that Firebase app instead.
   ```

