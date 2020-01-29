private String readcontacts(Context context, String cName) {
    ContentResolver cr = context.getContentResolver();
    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
            null, null, null);
    if (cur.getCount() > 0) {
        while (cur.moveToNext()) {
            String id = cur.getString(cur
                    .getColumnIndex(ContactsContract.Contacts._ID));
            String name = cur
                    .getString(
                            cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    .toLowerCase();
            if (name.equals(cName.toLowerCase())) {
                if (Integer
                        .parseInt(cur.getString(cur
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    // get the phone number
                    Cursor pCur = cr
                            .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                            + " = ?", new String[]{id},
                                    null);
                    while (pCur.moveToNext()) {
                        String phone = pCur
                                .getString(pCur
                                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        return phone;
                    }
                    pCur.close();
                }
            }
        }
    }
    return "Nothing found for " + cName + "!";
}
