package ge.credo.data;

import java.time.Month;

public enum GeorgianMonth {
    იან(1), თებ(2), მარ(3), აპრ(4), მაი(5), ივნ(6),
    ივლ(7), აგვ(8), სექ(9), ოქტ(10), ნოე(11), დეკ(12);

    private final int monthNumber;

    GeorgianMonth(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public static GeorgianMonth fromJavaMonth(Month month) {
        return switch (month) {
            case JANUARY -> იან;
            case FEBRUARY -> თებ;
            case MARCH -> მარ;
            case APRIL -> აპრ;
            case MAY -> მაი;
            case JUNE -> ივნ;
            case JULY -> ივლ;
            case AUGUST -> აგვ;
            case SEPTEMBER -> სექ;
            case OCTOBER -> ოქტ;
            case NOVEMBER -> ნოე;
            case DECEMBER -> დეკ;
        };
    }
}

