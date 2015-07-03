package org.josejuansanchez.playground.controllers;

import android.util.Log;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by josejuansanchez on 25/06/15.
 */
public class ADBController {
    public final static String TAG = "ADBController";
    private MainActivity mContext;

    public ADBController(MainActivity mContext) {
        this.mContext = mContext;
    }

    public String executeADBcommand(Message message) {
        try {
            Process process = Runtime.getRuntime().exec(message.getCommand());

            // TODO: Improve this temporary solution
            // TEST: This can block the app
            process.waitFor();

            BufferedReader bufferedReader = null;
            if (process.exitValue() == 0) {
                bufferedReader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    process.getInputStream().close();
                    process.getErrorStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();


        } catch(Exception e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
