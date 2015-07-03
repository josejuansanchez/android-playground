package org.josejuansanchez.playground;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by josejuansanchez on 28/06/15.
 */
public class Utils {
    private Context mContext;

    public Utils(Context mContext) {
        this.mContext = mContext;
    }

    public String loadFileFromAssets(String filename) {
        StringBuilder buf = new StringBuilder();

        try {
            InputStream html = null;
            html = mContext.getAssets().open(filename);
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(html, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return buf.toString();
    }

}
