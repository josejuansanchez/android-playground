package org.josejuansanchez.playground.transformations;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

/**
 * Created by josejuansanchez on 31/05/15.
 */
public class CropSquareTransformation implements Transformation {

    int x;
    int y;
    int width;
    int height;

    public CropSquareTransformation(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override public Bitmap transform(Bitmap source) {
        //int size = Math.min(source.getWidth(), source.getHeight());
        //int x = (source.getWidth() - size) / 4;  //2
        //int y = (source.getHeight() - size) / 4; //2;
        //Bitmap result = Bitmap.createBitmap(source, x, y, size, size);

        Bitmap result = Bitmap.createBitmap(source, x, y, width, height);

        if (result != source) {
            source.recycle();
        }
        return result;
    }

    @Override public String key() { return "square()"; }
}
