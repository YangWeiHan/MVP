package com.example.mryang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private ZXingView mZXingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mZXingView = findViewById(R.id.zxingview);
        //设置代理
        mZXingView.setDelegate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //打开相机
        mZXingView.startCamera();
        //显示扫描框，并且延迟1.5秒后开始识别
        mZXingView.startSpotAndShowRect();
        //打开闪光灯
        mZXingView.openFlashlight();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //关闭相机
        mZXingView.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZXingView.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        //成功
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {
        //环境改变 是否变暗  变暗为isDark 为 true
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        //打开手机失败
    }
}
