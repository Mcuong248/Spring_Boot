package vn.techmaster.joblisting.location;

public enum location {
    HaNoi ("Hà Nội"),
    HaiPhong ("Hải Phòng"),
    DaNang ("Đà Nẵng"),
    HoChiMinh ("Hồ Chí Minh");

    private String value;

    location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

