/*
Don't forget to declare the service on your manifest and enable the accessibility service on your application
Settings => Accessibility
You're welcome =)
/*

public class USSD extends AccessibilityService {

    // this class calls a method to return the string displayed when executing an USSD code 
    
    private String getEventType(AccessibilityEvent event) {
        switch (event.getEventType()) {
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                return "TYPE_NOTIFICATION_STATE_CHANGED";
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                return "TYPE_VIEW_CLICKED";
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                return "TYPE_VIEW_FOCUSED";
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                return "TYPE_VIEW_LONG_CLICKED";
            case AccessibilityEvent.TYPE_VIEW_SELECTED:
                return "TYPE_VIEW_SELECTED";
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                return "TYPE_WINDOW_STATE_CHANGED";
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                return "TYPE_VIEW_TEXT_CHANGED";
        }
        return "default";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Nazim", "AS Created");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        Log.d("Nazim","event : "+getEventText(event));
        if (event.getClassName().toString().equals("android.app.AlertDialog")) {

            //this dimisses Android predifined ussd Alert Dialog
            performGlobalAction(GLOBAL_ACTION_BACK);
            MainActivity.textView.setText("Crédit: "+fetchUssd(CREDIT_TEXT));
        }
    }

    private String getEventText(AccessibilityEvent event) {
        StringBuilder sb = new StringBuilder();
        for (CharSequence s : event.getText()) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public void onInterrupt() {

        Log.d("Nazim","AS interrupt");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d("Nazim","service connected");
        
        //setting AS filters and info
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.packageNames = new String[]{"com.android.phone"};
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Nazim","AS destroyed");
    }
    }
