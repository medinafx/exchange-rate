package ni.gob.inss.exchangerate.scraper;

import java.util.Objects;

public final class Cookie {

    private final String name;
    private final String value;

    public Cookie(String name, String value) {
        this.name = Objects.requireNonNull(name);
        this.value = Objects.requireNonNull(value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) o;
        return name.equals(cookie.name) &&
                value.equals(cookie.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Cookie{" + name + '=' + value + '}';
    }

}
