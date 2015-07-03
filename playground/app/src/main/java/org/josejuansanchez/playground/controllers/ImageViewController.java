package org.josejuansanchez.playground.controllers;

import android.graphics.Color;
import android.graphics.PointF;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import jp.wasabeef.picasso.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by josejuansanchez on 25/06/15.
 */
public class ImageViewController {

    private MainActivity mContext;

    public ImageViewController(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void loadImage(Message message) {

        Picasso.with(mContext).invalidate(message.getUrl());

        // Examples:
        // https://github.com/wasabeef/picasso-transformations/blob/master/example/src/main/java/jp/wasabeef/example/picasso/MainAdapter.java

        Transformation transformation = null;

        if (message.getTransformation() != null) {

            switch (message.getTransformation().getName()) {
                case "CropType":
                    transformation = new CropTransformation(
                            message.getTransformation().getWidth(),
                            message.getTransformation().getHeight(),
                            CropTransformation.CropType.TOP);
                    break;

                case "CropCenter":
                    transformation = new CropTransformation(
                            message.getTransformation().getWidth(),
                            message.getTransformation().getHeight());
                    break;

                case "CropBottom":
                    transformation = new CropTransformation(
                            message.getTransformation().getWidth(),
                            message.getTransformation().getHeight(),
                            CropTransformation.CropType.BOTTOM);
                    break;

                case "CropSquare":
                    transformation = new CropSquareTransformation();
                    break;

                case "CropCircle":
                    transformation = new CropCircleTransformation();
                    break;

                case "ColorFilter":
                    transformation = new ColorFilterTransformation(
                            Color.argb(message.getTransformation().getAlpha(),
                                    message.getTransformation().getRed(),
                                    message.getTransformation().getGreen(),
                                    message.getTransformation().getBlue()));
                    break;

                case "Grayscale":
                    transformation = new GrayscaleTransformation();
                    break;

                case "RoundedCorners":
                    transformation = new RoundedCornersTransformation(100, 0);
                    break;

                case "Blur":
                    transformation = new BlurTransformation(mContext, 10);
                    break;

                case "Toon":
                    transformation = new ToonFilterTransformation(mContext);
                    break;

                case "Sepia":
                    transformation = new SepiaFilterTransformation(mContext);
                    break;

                case "Contrast":
                    transformation = new ContrastFilterTransformation(mContext, 2.0f);
                    break;

                case "Invert":
                    transformation = new InvertFilterTransformation(mContext);
                    break;

                case "Pixel":
                    transformation = new PixelationFilterTransformation(mContext, message.getTransformation().getPixel());
                    break;

                case "Sketch":
                    transformation = new SketchFilterTransformation(mContext);
                    break;

                case "Swirl":
                    transformation = new SwirlFilterTransformation(mContext, 0.5f, 1.0f,
                            new PointF(0.5f, 0.5f));
                    break;

                case "Brightness":
                    transformation = new BrightnessFilterTransformation(mContext, 0.5f);
                    break;

                case "Kuawahara":
                    transformation = new KuwaharaFilterTransformation(mContext, 25);
                    break;

                case "Vignette":
                    transformation = new VignetteFilterTransformation(mContext,
                            new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f);
                    break;

            }

            Picasso.with(mContext).load(message.getUrl())
                    .transform(transformation)
                    .into(mContext.getmImageView());

        } else {
            //Picasso.with(this).load(message.getUrl()).fit().into(mImageView);
            Picasso.with(mContext).load(message.getUrl()).into(mContext.getmImageView());
        }


        /*
        if (message.getWidth() != 0 && message.getHeight() != 0) {

            Picasso.with(this).load(message.getUrl())
                    .transform(new CropSquareTransformation(message.getX(),message.getY(), message.getWidth(),message.getHeight()))
                    .into(mImageView);

        } else {
            Picasso.with(this).load(message.getUrl()).fit().into(mImageView);
            //Picasso.with(this).load(message.getUrl()).into(mImageView);
        }
        */
    }

}
