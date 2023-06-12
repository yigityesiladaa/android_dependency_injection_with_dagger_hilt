# Dependency Injection With Dagger Hilt

Dependency Injection (DI) is a design pattern to decouple the conventional dependency relationship between objects. When it comes to DI in android Dagger always takes a lead. But it is very complex and requires a lot of boilerplate codes in order to set up the Dagger. So, to overcome this problem Hilt was introduced. Dagger Hilt simplifies the whole process and reduces the unnecessary steps without losing any of the features of the original Dagger.

source: <a href = "https://www.geeksforgeeks.org/dagger-hilt-in-android-with-example/">GeeksForGeeks</a>

# Setup Dagger Hilt

### Dependencies

Add these codes to app level build.gradle file:

```kotlin
//Dagger - Hilt
implementation "com.google.dagger:hilt-android:2.44"
kapt "com.google.dagger:hilt-android-compiler:2.44"
kapt "androidx.hilt:hilt-compiler:1.0.0"
implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'
```

Then, these codes should be added to the module level build.gradle file in order to avoid "Duplicate Class error":

```kotlin
dependencies{

  constraints {
      implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
          because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
      }
      implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
          because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
      }
  }
  
  //Other Dependencies
  
}
```

Then, the following code should be added in the build.gradle file located at the app level:

```kotlin
android{

  namespace 'com.example'
  compileSdk 33
  
  ..
  ..
  
  kotlinOptions {
    jvmTarget = '1.8'
  }
  
  kapt {
    correctErrorTypes true
  }
  
}
```

And the following codes should be added to the plugins section in the same file:

```kotlin
plugins{
  id 'com.android.application'
  id 'org.jetbrains.kotlin.android'
  //Kapt
  id 'kotlin-kapt'
  //Dagger - Hilt
  id 'com.google.dagger.hilt.android'
}
```

As the last step of the gradle files, the following code should be added to the root level build.gradle file:

```kotlin
plugins{

  ..
  ..
  
  id 'org.jetbrains.kotlin.android' version '1.7.0' apply false
  //Dagger - Hilt
  id 'com.google.dagger.hilt.android' version '2.44' apply false
}
```

In addition, we need to add the Application Class named MyApp that we created in the project to the Manifest.xml file as follows:
```xml
<application
  android:name=".MyApp"
  android:allowBackup="true"
  android:dataExtractionRules="@xml/data_extraction_rules"
  
  ..
  ..
```

> :warning: **The versions given in the application dependencies are the current versions, but you may experience compatibility issues as these versions may change in the future. Therefore, I recommend checking the current versions of the specified dependencies during the Dagger Hilt installation.**

# Project Description

The project simulates the processing of data obtained using Retrofit. A real url is not used here, only a template is designed to be an example of Dependency Injection.

First of all, you should add the following codes to the app-level build.gradle file for the Retrofit library:

```kotlin
dependencies{

  ..
  ..
  
  // Retrofit
  implementation 'com.squareup.retrofit2:retrofit:2.9.0'
  implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.3"

}
```


What was explained here was how the dependencies used in the project should be added to the project. If you want to examine the codes in the project, you can access all the folders below:

MyApi.kt (Interface) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/data/remote/MyApi.kt">show</a>
</br>
MyRepository.kt (Interface) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/domain/repository/MyRepository.kt">show</a>
</br>
MyRepositoryImpl.kt (class) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/data/repository/MyRepositoryImpl.kt">show</a>
</br>
AppModule.kt (Object) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/di/AppModule.kt">show</a>
</br>
RepositoryModule.kt (Object) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/di/RepositoryModule.kt">show</a>
</br>
MyApp.kt (Application) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/MyApp.kt">show</a>
</br>
MyService.kt (Service) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/di/RepositoryModule.kt">show</a>
</br>
MyViewModel (ViewModel) -> <a href = "https://github.com/yigityesiladaa/android_dependency_injection_with_dagger_hilt/blob/main/app/src/main/java/com/dependencyinjectionwithdaggerhilt/MyViewModel.kt">show</a>


## Sources:

<a href = "https://www.geeksforgeeks.org/dagger-hilt-in-android-with-example/">GeeksForGeeks</a>
</br>
<a href = "https://www.youtube.com/watch?v=bbMsuI2p1DQ">Philipp Lackner</a>




