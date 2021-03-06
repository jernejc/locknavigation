/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/

package org.apache.cordova.locknavigation;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

import android.view.WindowManager;

public class LockNavigation extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

        if (action.equals("lock")) {

          cordova.getActivity().runOnUiThread(new Runnable() {
              public void run() {
                // Set the needed variables
                cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON
                  |WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                  |WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                  |WindowManager.LayoutParams.FLAG_FULLSCREEN);
                cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                
              }
          });

          callbackContext.success();
          return true;

        } else {

          return false;

        }

    } 

}
