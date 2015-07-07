package org.josejuansanchez.playground.controllers;

import android.media.AudioManager;
import android.speech.tts.TextToSpeech;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by josejuansanchez on 8/7/15.
 */
public class TextToSpeechController implements TextToSpeech.OnInitListener {
    public final static String TAG = "TextToSpeechController";
    private MainActivity mContext;
    private TextToSpeech mTts;
    private boolean mReady;

    public TextToSpeechController(MainActivity mContext) {
        this.mContext = mContext;
        this.mTts = new TextToSpeech(mContext, this);
    }

    public boolean isReady() {
        return mReady;
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            mTts.setLanguage(Locale.getDefault());
            mReady = true;
        }else{
            mReady = false;
        }
    }

    public void speak(Message message){
        if(isReady()) {
            HashMap<String, String> hash = new HashMap<String,String>();
            hash.put(TextToSpeech.Engine.KEY_PARAM_STREAM,
                    String.valueOf(AudioManager.STREAM_NOTIFICATION));
            mTts.speak(message.getText(), TextToSpeech.QUEUE_ADD, hash);
        }
    }

    public void pause(int duration){
        mTts.playSilence(duration, TextToSpeech.QUEUE_ADD, null);
    }

    public void destroy(){
        mTts.shutdown();
    }
}
