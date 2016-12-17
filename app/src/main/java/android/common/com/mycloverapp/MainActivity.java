package android.common.com.mycloverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.clover.remote.TxState;
import com.clover.remote.client.CloverConnector;
import com.clover.remote.client.ICloverConnectorListener;
import com.clover.remote.client.MerchantInfo;
import com.clover.remote.client.device.USBCloverDeviceConfiguration;
import com.clover.remote.client.messages.AuthResponse;
import com.clover.remote.client.messages.CaptureAuthResponse;
import com.clover.remote.client.messages.CloseoutResponse;
import com.clover.remote.client.messages.CloverDeviceErrorEvent;
import com.clover.remote.client.messages.CloverDeviceEvent;
import com.clover.remote.client.messages.ConfigErrorResponse;
import com.clover.remote.client.messages.ManualRefundResponse;
import com.clover.remote.client.messages.PreAuthResponse;
import com.clover.remote.client.messages.RefundPaymentResponse;
import com.clover.remote.client.messages.SaleRequest;
import com.clover.remote.client.messages.SaleResponse;
import com.clover.remote.client.messages.SignatureVerifyRequest;
import com.clover.remote.client.messages.TipAdjustAuthResponse;
import com.clover.remote.client.messages.VaultCardResponse;
import com.clover.remote.client.messages.VoidPaymentResponse;
import com.clover.remote.message.TipAddedMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.abc)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sale();
            }
        });
    }

    private void showMessage(final String msg) {
        runOnUiThread(new Runnable(){
            @Override public void run() {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sale(){
        ICloverConnectorListener listener = new ICloverConnectorListener() {
            @Override
            public void onDisconnected() {
                showMessage("onDisconnected");
            }

            @Override
            public void onConnected() {
                showMessage("onConnected");
            }

            @Override
            public void onReady(MerchantInfo merchantInfo) {
                showMessage("onReady");
            }

            @Override
            public void onError(Exception e) {
                showMessage("onError");
            }

            @Override
            public void onDebug(String s) {
                showMessage("onDebug");
            }

            @Override
            public void onDeviceActivityStart(CloverDeviceEvent deviceEvent) {
                showMessage("onDeviceActivityStart");
            }

            @Override
            public void onDeviceActivityEnd(CloverDeviceEvent deviceEvent) {
                showMessage("onDeviceActivityEnd");
            }

            @Override
            public void onDeviceError(CloverDeviceErrorEvent deviceErrorEvent) {
                showMessage("onDeviceError");
            }

            @Override
            public void onAuthResponse(AuthResponse response) {
                showMessage("onAuthResponse");
            }

            @Override
            public void onAuthTipAdjustResponse(TipAdjustAuthResponse response) {
                showMessage("onAuthTipAdjustResponse");
            }

            @Override
            public void onPreAuthCaptureResponse(CaptureAuthResponse response) {
                showMessage("onPreAuthCaptureResponse");
            }

            @Override
            public void onSignatureVerifyRequest(SignatureVerifyRequest request) {
                showMessage("onSignatureVerifyRequest");
            }

            @Override
            public void onCloseoutResponse(CloseoutResponse response) {
                showMessage("onCloseoutResponse");
            }

            @Override
            public void onSaleResponse(SaleResponse response) {
                showMessage("onSaleResponse");
            }

            @Override
            public void onPreAuthResponse(PreAuthResponse response) {
                showMessage("onPreAuthResponse");
            }

            @Override
            public void onManualRefundResponse(ManualRefundResponse response) {
                showMessage("onManualRefundResponse");
            }

            @Override
            public void onRefundPaymentResponse(RefundPaymentResponse response) {
                showMessage("onRefundPaymentResponse");
            }

            @Override
            public void onTipAdded(TipAddedMessage message) {
                showMessage("onTipAdded");
            }

            @Override
            public void onVoidPaymentResponse(VoidPaymentResponse response) {
                showMessage("onVoidPaymentResponse");
            }

            @Override
            public void onVaultCardResponse(VaultCardResponse response) {
                showMessage("onVaultCardResponse");
            }

            @Override
            public void onTransactionState(TxState txState) {
                showMessage("onTransactionState");
            }

            @Override
            public void onConfigErrorResponse(ConfigErrorResponse response) {
                showMessage("onConfigErrorResponse");
            }
        };

        CloverConnector connector = new CloverConnector(
                new USBCloverDeviceConfiguration(this), listener);
        SaleRequest request = new SaleRequest();
        request.setAmount(4681);
        connector.sale(request);
    }
}
