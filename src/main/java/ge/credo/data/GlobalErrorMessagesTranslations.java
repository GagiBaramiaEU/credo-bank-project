package ge.credo.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GlobalErrorMessagesTranslations {
    GLOBAL_ERROR_DATA_IS_INCORRECT("მონაცემები არასწორია", "მუნაჩემეფი ვა რე თინუ", "მონაცემოლ სწორ დემეგ ლი"),
    GLOBAL_ERROR_PROVIDED_DATA_IS_INCORRECT(
            "თქვენ მიერ შეყვანილი მონაცემები არასწორია, გთხოვთ შეიყვანეთ სწორი მონაცემები.",
            "თქვანი მიშაჸონაფილი მუნაჩემეფი უგუთინუ რე. რთხინთ, გემშიჸონათ თინუ მუნაჩემეფი",
            "ისგე სგა ლუინე/ლუირ მონაცემოლ სწორ დემეგ ლიხ, გთხოვთ სგა ადიედ სწორ მონაცემოლ"),
    GLOBAL_ERROR_USER_IS_BLOCKED("მომხმარებელი დაიბლოკა არასწორ მცდელობათა გამო. ბლოკის მოსახსნელად დაუკავშირდით ქოლ ცენტრს ან " +
                                       "გამოიყენეთ მონაცემების აღდგენა. განბლოკვა ავტომატურად მოხდება მომდევნო 30 წუთში.",
                                "მახვარებუქ დიბლოკჷ თინუ ვა რდუნ ფერი ცადალეფიშ გეშა. ბლოკიშ მანწყუმალო დეკავშირით ქოლ ცენტრის დო ვარ-და" +
                                        " გეგმირინეთ მუნაჩემეფიშ ეკონწყუალა. გიშაბლოკუა ავტომატურო მოხვადუ გეჸვენჯი 30 წუნთიშ დინახალე.",
                                "მომხმარებელ ჩვედბლოკავან არასწორ მცდელობაღა. ბლოკიშს ლფ\uE003შგად დაუკავშირდით ქოლ ცენტრს მადეი გამოიყენეთ მონაცემოლე აღდგენა. " +
                                        "განბლოკვა ავტომატურდ ხეხოლი მომდევნო 30 წუთისგა.");

    private final String geo;
    private final String megrel;
    private final String svan;

    public String get(Language language) {
        switch (language) {
            case GEO_LANGUAGE -> {
                return this.geo;
            }
            case MEGREL_LANGUAGE -> {
                return this.megrel;
            }
            case SVAN_LANGUAGE -> {
                return this.svan;
            }
            default -> throw new IllegalStateException("Unexpected value: " + language);
        }
    }
}