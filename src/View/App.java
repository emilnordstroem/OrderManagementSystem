package View;

import Domain.Controller.CustomerController;
import Domain.Controller.ItemController;
import Domain.Controller.OrderController;
import Domain.Models.*;
import View.orderOverview.MainWindow;
import javafx.application.Application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class App {
    private static final ArrayList<Customer> CUSTOMERARRAYLIST = new ArrayList<>();
    private static final ArrayList<Address> ADDRESSARRAYLIST = new ArrayList<>();
    private static final ArrayList<Order> ORDERSARRAYLIST = new ArrayList<>();
    private static final ArrayList<Item> ITEMARRAYLIST = new ArrayList<>();

    public static void main(String[] args) {
        innerStorage();
        Application.launch(MainWindow.class);
    }

    private static void innerStorage(){
        //==================================================================
        // Address data
        String[] streetNames = {
                "Kastanievej", "Søndermarksvej", "Strandvejen", "Rosenvej", "Elmegade", "Vesterbrogade", "Nørregade",
                "Søndergade", "Havnevej", "Kirkevej", "Skolevej", "Møllevej", "Parkvej", "Skovvej", "Åboulevarden",
                "Frederiksberg Allé", "Amagerbrogade", "Valby Langgade", "Nordre Fasanvej", "Jagtvej", "Istedgade",
                "Willemoesgade", "Classensgade", "Ryesgade", "Tulipanvej", "Rosenørns Allé", "Gammel Kongevej",
                "Vesterbrogade", "Nørre Allé", "Tagensvej", "Dannebrogsgade", "Gothersgade", "Adelgade", "Kompagnistræde",
                "Pilestræde", "Vimmelskaftet", "Strøget", "Kronprinsens Gade", "Grønnegade", "Larsbjørnsstræde", "Studiestræde",
                "Ny Vestergade", "Ny Kongensgade", "Landemærket", "Skindergade", "Fiolstræde", "Teglgårdstræde", "Klosterstræde",
                "Gråbrødretorv", "Fortunstræde"
        };

        String[] buildingNumbers = {
                "12", "24", "36", "48", "7", "15A", "22B", "33C", "45D", "8E", "17", "29", "41", "53", "6", "11", "23",
                "35", "47", "9", "16", "28", "40", "52", "5", "14", "26", "38", "50", "7B", "19", "31", "43", "55", "10",
                "13", "25", "37", "49", "8", "18", "30", "42", "54", "6A", "20", "32", "44", "56", "12C"
        };

        String[] postalCodes = {
                "2000", "1800", "2100", "2200", "2300", "2400", "2450", "2500", "2600", "2610", "2620", "2640", "2650",
                "2660", "2670", "2680", "2700", "2720", "2730", "2740", "2750", "2760", "2770", "2791", "2800", "2820",
                "2830", "2840", "2850", "2860", "2870", "2880", "2900", "2920", "2930", "2942", "2950", "2960", "2970",
                "2980", "2990", "3000", "3050", "3060", "3100", "3120", "3140", "3150", "3200", "3250", "3300", "3330",
                "3370", "3400", "3450", "3460", "3480", "3520", "3550", "3600", "3630", "3650", "3700", "3720", "3730",
                "3740", "3751", "3760", "3770", "3782", "3790"
        };

        String[] cities = {
                "Frederiksberg", "Frederiksberg C", "København Ø", "København N", "København S",
                "København NV", "København SV", "Valby", "Glostrup", "Rødovre", "Albertslund",
                "Hedehusene", "Hvidovre", "Brøndby Strand", "Greve", "Solrød", "Brønshøj",
                "Vanløse", "Herlev", "Skovlunde", "Ballerup", "Måløv", "Kastrup", "Dragør",
                "Kongens Lyngby", "Gentofte", "Virum", "Holte", "Nærum", "Søborg", "Dyssegård",
                "Bagsværd", "Hellerup", "Charlottenlund", "Klampenborg", "Skodsborg", "Vedbæk",
                "Rungsted Kyst", "Hørsholm", "Kokkedal", "Nivå", "Helsingør", "Humlebæk",
                "Espergærde", "Hornbæk", "Dronningmølle", "Ålsgårde", "Hellebæk", "Helsinge",
                "Gilleleje", "Frederiksværk", "Gørløse", "Hillerød", "Allerød", "Birkerød",
                "Fredensborg", "Farum", "Slangerup", "Frederikssund", "Jægerspris", "Ølstykke",
                "Rønne", "Aakirkeby", "Nexø", "Svaneke", "Østermarie", "Gudhjem", "Allinge",
                "Klemensker", "Hasle"
        };

        // Address generator
        for (int i = 0; i < 500; i++) {
            String streetName = streetNames[new Random().nextInt(streetNames.length)];
            String buildingNo = buildingNumbers[new Random().nextInt(buildingNumbers.length)];
            String postalCode = postalCodes[new Random().nextInt(postalCodes.length)];
            String city = cities[new Random().nextInt(cities.length)];
            String country = "Denmark";

            Address address = new Address(streetName, buildingNo, postalCode, city, country);
            ADDRESSARRAYLIST.add(address);
        }
        //==================================================================
        // Customer data
        String[] firstnames = {
                "Carl", "Frida", "William", "Luna", "Oscar", "Ella", "Alfred", "Alma", "Noah", "Emma",
                "Aksel", "Sofia", "Emil", "Olivia", "Oliver", "Agnes", "Malthe", "Ida", "Valdemar", "Karla",
                "August", "Ellie", "Theo", "Freja", "Arthur", "Nora", "Lucas", "Lily", "Elias", "Alberte",
                "Lauge", "Esther", "Otto", "Asta", "Hugo", "Ellen", "Felix", "Anna", "Magnus", "Aya",
                "Viggo", "Isabella", "Victor", "Lærke", "Theodor", "Astrid", "Loui", "Saga", "Holger", "Hannah",
                "Anker", "Mathilde", "Liam", "Josefine", "Anton", "Laura", "Matheo", "Vilma", "Konrad", "Emily",
                "Erik", "Liva", "Pelle", "Maja", "Luca", "Vera", "Asger", "Marie", "Ebbe", "Leonora",
                "Nohr", "Mille", "Vincent", "Andrea", "Kalle", "Solveig", "Adam", "Molly", "Johan", "Victoria",
                "Frederik", "Merle", "Storm", "Lea", "Albert", "Liv", "Walter", "Eva", "Alexander", "Ingrid",
                "Christian", "Elina", "Villads", "Rosa", "Leo", "Gry", "Anders", "Mette", "Jens", "Kirsten",
                "Henrik", "Lene", "Søren", "Hanne", "Peter", "Anne", "Michael", "Susanne", "Lars", "Maria",
                "Thomas", "Camilla", "Martin", "Louise", "Niels", "Tina", "Jørgen", "Inge", "Hans", "Lone",
                "Per", "Bente", "Ole", "Gitte", "Rasmus", "Pia", "Jan", "Karen", "Mads", "Charlotte",
                "Jesper", "Marianne", "Klaus", "Lise", "Claus", "Jette", "Bjarne", "Birgit", "Carsten", "Dorthe",
                "Bent", "Bodil", "Finn", "Grethe", "Flemming", "Birthe", "Mogens", "Else", "Poul", "Ulla",
                "Arne", "Annette", "Kurt", "Vibeke", "Erik", "Lene", "Henrik", "Mette", "Anders", "Kirsten",
                "Jens", "Hanne", "Søren", "Anne", "Peter", "Maria", "Michael", "Louise", "Lars", "Tina",
                "Thomas", "Camilla", "Martin", "Susanne", "Niels", "Inge", "Jørgen", "Lone", "Hans", "Bente",
                "Per", "Gitte", "Ole", "Pia", "Rasmus", "Karen", "Jan", "Charlotte", "Mads", "Marianne",
                "Jesper", "Carl", "Frida", "William", "Luna", "Oscar", "Ella", "Alfred", "Alma", "Noah",
                "Emma", "Aksel", "Sofia", "Emil", "Olivia", "Oliver", "Agnes", "Malthe", "Ida", "Valdemar",
                "Karla", "August", "Ellie", "Theo", "Freja", "Arthur", "Nora", "Lucas", "Lily", "Elias",
                "Alberte", "Lauge", "Esther", "Otto", "Asta", "Hugo", "Ellen", "Felix", "Anna", "Magnus",
                "Aya", "Viggo", "Isabella", "Victor", "Lærke", "Theodor", "Astrid", "Loui", "Saga", "Holger",
                "Hannah"
        };

        String[] lastNames = {
                "Nielsen", "Jensen", "Hansen", "Pedersen", "Andersen", "Christensen", "Larsen", "Sørensen",
                "Rasmussen", "Jørgensen", "Petersen", "Madsen", "Kristensen", "Olsen", "Thomsen", "Christiansen",
                "Poulsen", "Johansen", "Møller", "Mortensen", "Bendtsen", "Lund", "Frederiksen", "Mikkelsen",
                "Kjær", "Berg", "Holm", "Dahl", "Jakobsen", "Bech", "Nørgaard", "Vestergaard", "Gregersen",
                "Laursen", "Frandsen", "Østergaard", "Knudsen", "Jacobsen", "Carlsen", "Nissen", "Winther",
                "Mogensen", "Dalgaard", "Toft", "Iversen", "Svendsen", "Jeppesen", "Nygaard", "Andreasen",
                "Bak", "Lassen", "Thomassen", "Lorentzen", "Jespersen", "Kjeldsen", "Bonde", "Krogh", "Lauridsen",
                "Danielsen", "Mathiesen", "Andresen", "Brandt", "Winther", "Toft", "Mogensen", "Lindberg",
                "Kjærsgaard", "Riis", "Clausen", "Kruse", "Kofoed", "Ravn", "Bentsen", "Bjerregaard", "Lundgaard",
                "Nielsen", "Jensen", "Hansen", "Pedersen", "Andersen", "Christensen", "Larsen", "Sørensen",
                "Rasmussen", "Jørgensen", "Petersen", "Madsen", "Kristensen", "Olsen", "Thomsen", "Christiansen",
                "Poulsen", "Johansen", "Møller", "Mortensen", "Bendtsen", "Lund", "Frederiksen", "Mikkelsen",
                "Kjær", "Berg", "Holm", "Dahl", "Jakobsen", "Bech", "Nørgaard", "Vestergaard", "Gregersen",
                "Laursen", "Frandsen", "Østergaard", "Knudsen", "Jacobsen", "Carlsen", "Nissen", "Winther",
                "Mogensen", "Dalgaard", "Toft", "Iversen", "Svendsen", "Jeppesen", "Nygaard", "Andreasen",
                "Bak", "Lassen", "Thomassen", "Lorentzen", "Jespersen", "Kjeldsen", "Bonde", "Krogh", "Lauridsen",
                "Danielsen", "Mathiesen", "Andresen", "Brandt", "Winther", "Toft", "Mogensen", "Lindberg",
                "Kjærsgaard", "Riis", "Clausen", "Kruse", "Kofoed", "Ravn", "Bentsen", "Bjerregaard", "Lundgaard",
                "Nielsen", "Jensen", "Hansen", "Pedersen", "Andersen", "Christensen", "Larsen", "Sørensen",
                "Rasmussen", "Jørgensen", "Petersen", "Madsen", "Kristensen", "Olsen", "Thomsen", "Christiansen",
                "Poulsen", "Johansen", "Møller", "Mortensen", "Bendtsen", "Lund", "Frederiksen", "Mikkelsen",
                "Kjær", "Berg", "Holm", "Dahl", "Jakobsen", "Bech", "Nørgaard", "Vestergaard", "Gregersen",
                "Laursen", "Frandsen", "Østergaard", "Knudsen", "Jacobsen", "Carlsen", "Nissen", "Winther",
                "Mogensen", "Dalgaard", "Toft", "Iversen", "Svendsen", "Jeppesen", "Nygaard", "Andreasen",
                "Bak", "Lassen", "Thomassen", "Lorentzen", "Jespersen", "Kjeldsen", "Bonde", "Krogh", "Lauridsen",
                "Danielsen", "Mathiesen", "Andresen", "Brandt", "Winther", "Toft", "Mogensen", "Lindberg",
                "Kjærsgaard", "Riis", "Clausen", "Kruse", "Kofoed", "Ravn", "Bentsen", "Bjerregaard", "Lundgaard"
        };

        String[] uniqueEmails = {
                "carl.nielsen@example.dk", "frida.jensen@example.dk", "william.hansen@example.dk",
                "luna.pedersen@example.dk", "oscar.andersen@example.dk", "ella.christensen@example.dk",
                "alfred.larsen@example.dk", "alma.sorensen@example.dk", "noah.rasmussen@example.dk",
                "emma.jorgensen@example.dk", "aksel.petersen@example.dk", "sofia.madsen@example.dk",
                "emil.kristensen@example.dk", "olivia.olsen@example.dk", "oliver.thomsen@example.dk",
                "agnes.christiansen@example.dk", "malthe.poulsen@example.dk", "ida.johansen@example.dk",
                "valdemar.moller@example.dk", "karla.mortensen@example.dk", "august.bendtsen@example.dk",
                "ellie.lund@example.dk", "theo.frederiksen@example.dk", "freja.mikkelsen@example.dk",
                "arthur.kjaer@example.dk", "nora.berg@example.dk", "lucas.holm@example.dk",
                "lily.dahl@example.dk", "elias.jakobsen@example.dk", "alberte.bech@example.dk",
                "lauge.norgaard@example.dk", "esther.vestergaard@example.dk", "otto.gregersen@example.dk",
                "asta.laursen@example.dk", "hugo.frandsen@example.dk", "ellen.ostergaard@example.dk",
                "felix.knudsen@example.dk", "anna.jacobsen@example.dk", "magnus.carlsen@example.dk",
                "aya.nissen@example.dk", "viggo.winther@example.dk", "isabella.mogensen@example.dk",
                "victor.dalgaard@example.dk", "laerke.toft@example.dk", "theodor.iversen@example.dk",
                "astrid.svendsen@example.dk", "loui.jeppesen@example.dk", "saga.nygaard@example.dk",
                "holger.andreasen@example.dk", "hannah.bak@example.dk", "anker.lassen@example.dk",
                "mathilde.thomassen@example.dk", "liam.lorentzen@example.dk", "josefine.jespersen@example.dk",
                "anton.kjeldsen@example.dk", "laura.bonde@example.dk", "matheo.krogh@example.dk",
                "vilma.lauridsen@example.dk", "konrad.danielsen@example.dk", "emily.mathiesen@example.dk",
                "erik.andresen@example.dk", "liva.brandt@example.dk", "pelle.lindberg@example.dk",
                "maja.kjaersgaard@example.dk", "luca.riis@example.dk", "vera.clausen@example.dk",
                "asger.kruse@example.dk", "marie.kofoed@example.dk", "ebbe.ravn@example.dk",
                "leonora.bentsen@example.dk", "nohr.bjerregaard@example.dk", "mille.lundgaard@example.dk",
                "vincent.nielsen@example.dk", "andrea.jensen@example.dk", "kalle.hansen@example.dk",
                "solveig.pedersen@example.dk", "adam.andersen@example.dk", "molly.christensen@example.dk",
                "johan.larsen@example.dk", "victoria.sorensen@example.dk", "frederik.rasmussen@example.dk",
                "merle.jorgensen@example.dk", "storm.petersen@example.dk", "lea.madsen@example.dk",
                "albert.kristensen@example.dk", "liv.olsen@example.dk", "walter.thomsen@example.dk",
                "eva.christiansen@example.dk", "alexander.poulsen@example.dk", "ingrid.johansen@example.dk",
                "christian.moller@example.dk", "elina.mortensen@example.dk", "villads.bendtsen@example.dk",
                "rosa.lund@example.dk", "leo.frederiksen@example.dk", "gry.mikkelsen@example.dk",
                "anders.kjaer@example.dk", "mette.berg@example.dk", "jens.holm@example.dk",
                "kirsten.dahl@example.dk", "henrik.jakobsen@example.dk", "lene.bech@example.dk",
                "soren.norgaard@example.dk", "hanne.vestergaard@example.dk", "peter.gregersen@example.dk",
                "anne.laursen@example.dk", "michael.frandsen@example.dk", "susanne.ostergaard@example.dk",
                "lars.knudsen@example.dk", "maria.jacobsen@example.dk", "thomas.carlsen@example.dk",
                "camilla.nissen@example.dk", "martin.winther@example.dk", "louise.mogensen@example.dk",
                "niels.dalgaard@example.dk", "tina.toft@example.dk", "jorgen.iversen@example.dk",
                "inge.svendsen@example.dk", "hans.jeppesen@example.dk", "lone.nygaard@example.dk",
                "per.andreasen@example.dk", "bente.bak@example.dk", "ole.lassen@example.dk",
                "gitte.thomassen@example.dk", "rasmus.lorentzen@example.dk", "pia.jespersen@example.dk",
                "jan.kjeldsen@example.dk", "karen.bonde@example.dk", "mads.krogh@example.dk",
                "charlotte.lauridsen@example.dk", "jesper.danielsen@example.dk", "marianne.mathiesen@example.dk",
                "klaus.andresen@example.dk", "lise.brandt@example.dk", "claus.lindberg@example.dk",
                "jette.kjaersgaard@example.dk", "bjarne.riis@example.dk", "birgit.clausen@example.dk",
                "carsten.kruse@example.dk", "dorthe.kofoed@example.dk", "bent.ravn@example.dk",
                "bodil.bentsen@example.dk", "finn.bjerregaard@example.dk", "grethe.lundgaard@example.dk", "flemming.nielsen@example.dk", "birthe.jensen@example.dk",
                "mogens.hansen@example.dk", "else.pedersen@example.dk", "poul.andersen@example.dk",
                "ulla.christensen@example.dk", "arne.larsen@example.dk", "annette.sorensen@example.dk",
                "kurt.rasmussen@example.dk", "vibeke.jorgensen@example.dk", "erik.petersen@example.dk",
                "lene.madsen@example.dk", "henrik.kristensen@example.dk", "mette.olsen@example.dk",
                "anders.thomsen@example.dk", "kirsten.christiansen@example.dk", "jens.poulsen@example.dk",
                "hanne.johansen@example.dk", "soren.moller@example.dk", "anne.mortensen@example.dk",
                "peter.bendtsen@example.dk", "maria.lund@example.dk", "michael.frederiksen@example.dk",
                "louise.mikkelsen@example.dk", "lars.kjaer@example.dk", "tina.berg@example.dk",
                "thomas.holm@example.dk", "camilla.dahl@example.dk", "martin.jakobsen@example.dk",
                "susanne.bech@example.dk", "niels.norgaard@example.dk", "inge.vestergaard@example.dk",
                "jorgen.gregersen@example.dk", "lone.laursen@example.dk", "hans.frandsen@example.dk",
                "bente.ostergaard@example.dk", "ole.knudsen@example.dk", "gitte.jacobsen@example.dk",
                "rasmus.carlsen@example.dk", "pia.nissen@example.dk", "jan.winther@example.dk",
                "karen.mogensen@example.dk", "mads.dalgaard@example.dk", "charlotte.toft@example.dk",
                "jesper.iversen@example.dk", "marianne.svendsen@example.dk", "klaus.jeppesen@example.dk",
                "lise.nygaard@example.dk", "claus.andreasen@example.dk", "jette.bak@example.dk",
                "bjarne.lassen@example.dk", "birgit.thomassen@example.dk", "carsten.lorentzen@example.dk",
                "dorthe.jespersen@example.dk", "bent.kjeldsen@example.dk", "bodil.bonde@example.dk",
                "finn.krogh@example.dk", "grethe.lauridsen@example.dk", "flemming.danielsen@example.dk",
                "birthe.mathiesen@example.dk", "mogens.andresen@example.dk", "else.brandt@example.dk",
                "poul.lindberg@example.dk", "ulla.kjaersgaard@example.dk", "arne.riis@example.dk",
                "annette.clausen@example.dk", "kurt.kruse@example.dk", "vibeke.kofoed@example.dk",
                "erik.ravn@example.dk", "lene.bentsen@example.dk", "henrik.bjerregaard@example.dk",
                "mette.lundgaard@example.dk", "anders.nielsen@example.dk", "kirsten.jensen@example.dk",
                "jens.hansen@example.dk", "hanne.pedersen@example.dk", "soren.andersen@example.dk",
                "anne.christensen@example.dk", "peter.larsen@example.dk", "maria.sorensen@example.dk",
                "michael.rasmussen@example.dk", "louise.jorgensen@example.dk", "lars.petersen@example.dk",
                "tina.madsen@example.dk", "thomas.kristensen@example.dk", "camilla.olsen@example.dk",
                "martin.thomsen@example.dk", "susanne.christiansen@example.dk", "niels.poulsen@example.dk",
                "inge.johansen@example.dk", "jorgen.moller@example.dk", "lone.mortensen@example.dk",
                "hans.bendtsen@example.dk", "bente.lund@example.dk", "ole.frederiksen@example.dk",
                "gitte.mikkelsen@example.dk", "rasmus.kjaer@example.dk", "pia.berg@example.dk",
                "jan.holm@example.dk", "karen.dahl@example.dk", "mads.jakobsen@example.dk",
                "charlotte.bech@example.dk", "jesper.norgaard@example.dk", "marianne.vestergaard@example.dk",
                "klaus.gregersen@example.dk", "lise.laursen@example.dk", "claus.frandsen@example.dk",
                "jette.ostergaard@example.dk", "bjarne.knudsen@example.dk", "birgit.jacobsen@example.dk",
                "carsten.carlsen@example.dk", "dorthe.nissen@example.dk", "bent.winther@example.dk",
                "bodil.mogensen@example.dk", "finn.dalgaard@example.dk", "grethe.toft@example.dk",
                "flemming.iversen@example.dk", "birthe.svendsen@example.dk", "mogens.jeppesen@example.dk",
                "else.nygaard@example.dk", "poul.andreasen@example.dk", "ulla.bak@example.dk",
                "arne.lassen@example.dk", "annette.thomassen@example.dk", "kurt.lorentzen@example.dk",
                "vibeke.jespersen@example.dk", "erik.kjeldsen@example.dk", "lene.bonde@example.dk",
                "henrik.krogh@example.dk", "mette.lauridsen@example.dk", "anders.danielsen@example.dk",
                "kirsten.mathiesen@example.dk", "jens.andresen@example.dk", "hanne.brandt@example.dk",
                "soren.lindberg@example.dk", "anne.kjaersgaard@example.dk", "peter.riis@example.dk",
                "maria.clausen@example.dk", "michael.kruse@example.dk", "louise.kofoed@example.dk",
                "lars.ravn@example.dk", "tina.bentsen@example.dk", "thomas.bjerregaard@example.dk",
                "camilla.lundgaard@example.dk"
        };

        // Customer generator
        for (int i = 0; i < 250; i++) {
            String firstName = firstnames[new Random().nextInt(firstnames.length)];
            String lastName = lastNames[new Random().nextInt(lastNames.length)];

            String fullName = String.format("%s %s", firstName, lastName);
            String email = uniqueEmails[i];
            String phoneNo = generateRandomPhoneNumber();
            LocalDate dateOfBirth = generateRandomDateOfBirth();
            Address address = ADDRESSARRAYLIST.get(new Random().nextInt(ADDRESSARRAYLIST.size() - 1));
            Payment payment = new Payment(fullName);

            Customer customer = CustomerController.createCustomer(firstName, lastName, phoneNo, email, dateOfBirth, address, payment);
            CUSTOMERARRAYLIST.add(customer);
        }


        //==================================================================
        // Item data
        String[] itemNames = {
                // Electronics
                "Smartphone", "Laptop", "Tablet", "Smartwatch", "Wireless Earbuds",
                "Gaming Console", "Digital Camera", "Bluetooth Speaker", "Smart TV", "Wireless Charger",
                // Home Appliances
                "Blender", "Coffee Maker", "Microwave", "Vacuum Cleaner", "Air Purifier",
                "Electric Kettle", "Rice Cooker", "Toaster", "Food Processor", "Refrigerator",
                // Kitchen Tools
                "Chef's Knife", "Cutting Board", "Kitchen Scale", "Mixing Bowl Set", "Measuring Cups",
                "Spatula", "Whisk", "Cooking Thermometer", "Pepper Grinder", "Salt Shaker",
                // Office Supplies
                "Notebook", "Pen Set", "Desk Lamp", "Ergonomic Chair", "Wireless Mouse",
                "Noise-Canceling Headphones", "Portable Hard Drive", "Desk Organizer", "Printer", "Monitor",
                // Repeated Items (for variety)
                "Smartphone", "Laptop", "Blender", "Chef's Knife", "Wireless Earbuds"
        };

        String[] itemDescriptions = {
                // Electronics Descriptions
                "Latest model with 5G connectivity and advanced camera system",
                "High-performance ultrabook with powerful processor",
                "Lightweight tablet with crisp display and long battery life",
                "Fitness tracking smartwatch with heart rate monitoring",
                "Noise-canceling wireless earbuds with premium sound quality",
                "Next-generation gaming console with 4K graphics",
                "Professional-grade digital camera with interchangeable lenses",
                "Portable bluetooth speaker with immersive sound",
                "Smart TV with 4K resolution and streaming capabilities",
                "Fast charging wireless charger compatible with multiple devices",
                // Home Appliances Descriptions
                "High-powered blender for smoothies and food processing",
                "Programmable coffee maker with built-in grinder",
                "Compact microwave with multiple cooking settings",
                "Powerful vacuum cleaner with HEPA filtration",
                "Advanced air purifier with multi-stage filtration",
                "Quick-boil electric kettle with temperature control",
                "Smart rice cooker with multiple cooking modes",
                "Wide-slot toaster with digital browning controls",
                "Multi-functional food processor with various attachments",
                "Energy-efficient refrigerator with smart temperature management",
                // Kitchen Tools Descriptions
                "Professional-grade stainless steel chef's knife",
                "Eco-friendly bamboo cutting board with juice groove",
                "Precision digital kitchen scale for accurate measurements",
                "Durable stainless steel mixing bowl set with non-slip base",
                "Accurate measuring cup set with clear markings",
                "Heat-resistant silicone spatula for versatile cooking",
                "Stainless steel whisk for perfect mixing and beating",
                "Digital cooking thermometer for precise temperature control",
                "Adjustable ceramic pepper grinder with ceramic mechanism",
                "Elegant glass salt shaker with stainless steel top",
                // Office Supplies Descriptions
                "Premium hardcover notebook with high-quality paper",
                "Luxury pen set with smooth writing experience",
                "Adjustable LED desk lamp with color temperature control",
                "Ergonomic office chair with lumbar support",
                "Wireless mouse with precision tracking",
                "Professional noise-canceling headphones with long battery life",
                "Compact portable hard drive with high-speed data transfer",
                "Modular desk organizer with multiple compartments",
                "All-in-one wireless printer with scanning capabilities",
                "Ultra-wide monitor with color-accurate display",
                // Repeated Item Descriptions
                "Budget-friendly smartphone with essential features",
                "Affordable laptop for everyday computing needs",
                "Compact blender for small kitchens and quick smoothies",
                "Affordable kitchen knife for home cooking enthusiasts",
                "Budget wireless earbuds with decent sound quality"
        };

        // Item generator
        for(int number = 0; number < 100; number++){
            int randomItem = new Random().nextInt(itemNames.length);
            Item item = ItemController.createItem(itemNames[randomItem], itemDescriptions[randomItem],new Random().nextDouble(49, 1699) + 1);
            ITEMARRAYLIST.add(item);
        }

        //==================================================================
        // Order generator

        for(int outerIndex = 0; outerIndex < 500; outerIndex++){
            Customer customer = CUSTOMERARRAYLIST.get(new Random().nextInt(0, CUSTOMERARRAYLIST.size() - 1));

            ArrayList<Item> itemArrayList = new ArrayList<>();
            int numberOfItems = new Random().nextInt(1,7);
            for(int innerIndex = 0; innerIndex < numberOfItems; innerIndex++){
                Item item = ITEMARRAYLIST.get(new Random().nextInt(0, ITEMARRAYLIST.size() - 1));
                itemArrayList.add(item);
            }

            Order order = OrderController.createOrder(customer, itemArrayList, customer.getAddress());
            ORDERSARRAYLIST.add(order);
        }

    }
    private static String generateRandomPhoneNumber() {
        // Danish phone numbers are typically 8 digits
        return String.format("%08d", new Random().nextInt(100000000));
    }

    private static LocalDate generateRandomDateOfBirth() {
        // Generate a random date of birth between 1950 and 2005
        int year = 1950 + new Random().nextInt(56);
        int month = 1 + new Random().nextInt(12);
        int day = 1 + new Random().nextInt(28); // Simplifying to avoid month-specific day counts
        return LocalDate.of(year, month, day);
    }
}
