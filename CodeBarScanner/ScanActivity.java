public class ScanActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {

    private ZBarScannerView mScannerView;
    //camera permission is needed.

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        if (ContextCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(ScanActivity.this, new String[] {Manifest.permission.CAMERA}, 1);
        }
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }
    @Override
    public void handleResult(Result result) {
        // Do something with the result here
        Log.v("Nazim", result.getContents()); // Prints scan results
        Log.v("Nazim", result.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        MainActivity.creditText.setText(result.getContents());
        onBackPressed();
    }
}
