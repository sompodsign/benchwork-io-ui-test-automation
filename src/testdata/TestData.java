package testdata;

public class TestData {

    public static String getRandomParagraph() {

        String[] paragraphs = {"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",

        };

        return paragraphs[(int) (Math.random() * paragraphs.length)];

    }

    public static String getRandomSentence() {
        return "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
    }

    public static String getRandomWord() {
        return getRandomParagraph().split(" ")[(int) (Math.random() * getRandomParagraph().split(" ").length)];
    }

    public static String getRandomNumber() {
        int randomNumber = (int) (Math.random() * 100);
        return String.valueOf(randomNumber);
    }

    public static String getRandomEmail() {
        String email = "";

        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com"};

        email = getRandomWord() + "_" + getRandomNumber() + "@" + domains[(int) (Math.random() * domains.length)];

        return email;
    }

    public static String getRandomChars(int length) {
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < length; i++) {
            chars.append((char) (Math.random() * 26 + 97));
        }
        return chars.toString();
    }

    public static String getRandomDigits(int length) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < length; i++) {
            digits.append((int) (Math.random() * 10));
        }
        return digits.toString();
    }

    public static String getRandomSymbol(int length) {
        String[] symbols = {"!", "@", "$", "%", "^", "&", "*", "(", ")", "-"};
        StringBuilder symbolsBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            symbolsBuilder.append(symbols[(int) (Math.random() * symbols.length)]);
        }
        return symbolsBuilder.toString();
    }

    public static String getCapitalLetter(int length) {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < length; i++) {
            chars.append(letters[(int) (Math.random() * letters.length)]);
        }
        return chars.toString();
    }

    public static String getSmallLetter(int length) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < length; i++) {
            chars.append(letters[(int) (Math.random() * letters.length)]);
        }
        return chars.toString();
    }

    public static String getRandomCity() {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose"};
        return cities[(int) (Math.random() * cities.length)];
    }

    public static String getRandomState() {
        String[] states = {"New York", "California", "Illinois", "Texas", "Arizona", "Colorado", "Massachusetts", "Hawaii", "Virginia"};
        return states[(int) (Math.random() * states.length)];
    }

    public static String getRandomCountry() {
        String[] countries = {"United States", "Canada", "United Kingdom", "France", "Japan", "China", "Germany", "Italy", "Spain"};
        return countries[(int) (Math.random() * countries.length)];
    }

    public static String getRandomStreet() {
        String[] streets = {"Main Street", "Church Street", "East Street", "West Street", "North Street", "South Street", "Park Street", "Broadway"};
        return streets[(int) (Math.random() * streets.length)];
    }

    public static String getRandomZipCode() {
        String[] zipCodes = {"11111", "22222", "33333", "44444", "55555", "66666", "77777", "88888", "99999"};
        return zipCodes[(int) (Math.random() * zipCodes.length)];
    }

    public static String getRandomBrands() {
        String[] brands = {"Apple", "Samsung", "HTC", "Nokia", "Sony", "LG", "Motorola", "Blackberry", "Microsoft"};
        return brands[(int) (Math.random() * brands.length)];
    }

    public static String getRandomColors() {
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "White", "Pink", "Gray", "Orange"};
        return colors[(int) (Math.random() * colors.length)];
    }

    public static String getRandomFirstName() {
        String[] firstNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles"};
        return firstNames[(int) (Math.random() * firstNames.length)];
    }

    public static String getRandomLastName() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"};
        return lastNames[(int) (Math.random() * lastNames.length)];
    }

    public static String getRandomFullName() {
        return getRandomFirstName() + " " + getRandomLastName();
    }

    public static String getRandomPhoneNumber() {
        return getRandomDigits(3) + "-" + getRandomDigits(3) + "-" + getRandomDigits(4);
    }

    public static String generateStrongPassword(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(getRandomDigits(1));
        }
        password.append(getCapitalLetter(1));
        password.append(getSmallLetter(1));
        password.append(getRandomSymbol(1));
        return password.toString();
    }

    public static String getRandomGirlName() {
        String[] girlNames = {"Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer", "Maria", "Susan", "Margaret"};
        return girlNames[(int) (Math.random() * girlNames.length)];
    }

    public static String getRandomBoyName() {
        String[] boyNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles"};
        return boyNames[(int) (Math.random() * boyNames.length)];
    }

    public static String getRandomGirlFullName() {
        return getRandomGirlName() + " " + getRandomLastName();
    }

    public static String getRandomBoyFullName() {
        return getRandomBoyName() + " " + getRandomLastName();
    }

    public static String getRandomBollywoodActorName() {
        String[] bollywoodActorNames = {"Aamir Khan", "Akshay Kumar", "Amitabh Bachchan", "Amitabh Bachchan", "Amitabh Bachchan", "Amitabh Bachchan", "Amitabh Bachchan", "Amitabh Bachchan", "Amitabh Bachchan", "Amitabh Bachchan"};
        return bollywoodActorNames[(int) (Math.random() * bollywoodActorNames.length)];
    }

    public static String getRandomHollywoodActorName() {
        String[] hollywoodActorNames = {"Robert Downey Jr.", "Chris Evans", "Chris Hemsworth", "Chris Pratt", "Chris Hemsworth", "Chris Hemsworth", "Chris Hemsworth", "Chris Hemsworth", "Chris Hemsworth", "Chris Hemsworth"};
        return hollywoodActorNames[(int) (Math.random() * hollywoodActorNames.length)];
    }

    public static String getRandomMovieNames() {

        String[] movieNames = {"Avengers", "Avengers", "Avengers", "Avengers", "Avengers", "Avengers", "Avengers", "Avengers", "Avengers", "Avengers"};
        return movieNames[(int) (Math.random() * movieNames.length)];
    }

    public static String getDollarCurrentPrice() {
        return "$" + getRandomDigits(2) + "." + getRandomDigits(2);
    }

    public static String getRandomGameNames() {
        String[] gameNames = {"Fortnite", "Fortnite", "Fortnite", "Fortnite", "Fortnite", "Fortnite", "Fortnite", "Fortnite", "Fortnite", "Fortnite"};
        return gameNames[(int) (Math.random() * gameNames.length)];
    }

    public static String getBasicPassword() {
        return "password";
    }

    public static String getRandomImage() {

        String[] photos = {"banner.png", "coupon.jpg", "icon.png", "main_banner.jpg", "passport-id.jpg", "test-image-1.jpg", "test_profile_image.png", "unidevGO.jpg"};
        return photos[(int) (Math.random() * photos.length)];
    }

    public static String getRandomUsername() {
        String username = "";

        String[] firstNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles"};

        username += firstNames[(int) (Math.random() * firstNames.length)];
        int randomNumber = (int) (Math.random() * 100000000);
        username += "_" + getRandomDigits(2)+ randomNumber;
        return username;


    }

    public static String getRandomWebsite() {
        return "www."+getRandomLastName().toLowerCase()+getRandomDigits(3)+getRandomWord().toLowerCase()+".com";
    }

    public static String getRandomVideo() {
        String[] videos = {"test-video-1.mp4"};
        return videos[(int) (Math.random() * videos.length)];
    }


}
