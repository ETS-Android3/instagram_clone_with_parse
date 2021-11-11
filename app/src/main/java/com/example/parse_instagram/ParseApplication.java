package com.example.parse_instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Register your parse models
    ParseObject.registerSubclass(Post.class);

    // Parse initialize
    Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("9MYGM21ZUyWUs6tRYBknWJjFOAa3n5jeOxLp7cne")
            .clientKey("vb2h0SKMGuMR3JArN11HcSPzl0SNzx4SH74YiZuF")
            .server("https://parseapi.back4app.com")
            .build()
    );
  }
}
