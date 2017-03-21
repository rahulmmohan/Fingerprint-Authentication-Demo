package com.overrideandroid.fingerprintauthenticationdemo;

import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

/**
 * Created by rahul.m on 21-03-2017.
 */

public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private Context mContext;

    public FingerprintHandler(Context context) {
        this.mContext = context;
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
    }

    @Override
    public void onAuthenticationSucceeded(AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        ((MainActivity) mContext).showAuthSucceededMessage();
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        ((MainActivity) mContext).showAuthFailedMessage();
    }


    public void doAuthentication(FingerprintManager fingerprintManager, CryptoObject cryptoObject) {
        CancellationSignal signal = new CancellationSignal();
        if (ActivityCompat.checkSelfPermission(mContext, permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fingerprintManager.authenticate(cryptoObject, signal,0, this, null);
    }
}
