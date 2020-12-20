package Builder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder().
                addFirstName("Alexandra").
                addLastName("Mostovaya").
                addMiddleName("Vladimirovna").
                addCountry(new Country()).
                addGender(new Gender()).
                addPhone("777777").
                addAge(34).
                addAddress("Ust-Kamenogorsk").build();
    }
}

    class Gender {
    }

    class Country{
    }

    class Person {

        private String firstName;
        private String lastName;
        private String middleName;
        private Country country;
        private String address;
        private String phone;
        private int age;
        private Gender gender;

        public static class Builder {
            private String firstName;
            private String lastName;
            private String middleName;
            private Country country;
            private String address;
            private String phone;
            private int age;
            private Gender gender;

            public Builder addFirstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder addLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder addMiddleName(String middleName) {
                this.middleName = middleName;
                return this;
            }

            public Builder addCountry(Country country) {
                this.country = country;
                return this;
            }

            public Builder addAddress(String address) {
                this.address = address;
                return this;
            }

            public Builder addPhone(String phone) {
                this.phone = phone;
                return this;
            }

            public Builder addAge(int age) {
                this.age = age;
                return this;
            }

            public Builder addGender(Gender gender) {
                this.gender = gender;
                return this;
            }

            public Person build() {
                return new Person();
            }


        }
    }













