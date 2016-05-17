# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-dontwarn com.google.code.**
-dontwarn  org.apache.**
-dontwarn  com.google.android.**
-dontwarn  com.android.**
-dontwarn  com.braintreepayments.**
-dontwarn  me.**
-dontwarn  de.hdodenhof.**
-dontwarn  com.github.rey5137.**


#Acra
-keep class com.google.code.**  { *; }
-keepattributes Signature

#Acra
-keep class org.apache.**  { *; }
-keepattributes Signature

#Acra
-keep class com.google.android.**  { *; }
-keepattributes Signature

#Acra
-keep class com.android.**  { *; }
-keepattributes Signature

#Acra
-keep class com.braintreepayments.**  { *; }
-keepattributes Signature

#Acra
-keep class me.**  { *; }
-keepattributes Signature

#Acra
-keep class de.hdodenhof.**  { *; }
-keepattributes Signature

#Acra
-keep class com.github.rey5137.**  { *; }
-keepattributes Signature
