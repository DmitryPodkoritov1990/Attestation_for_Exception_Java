public class ExceptionOfGender extends Exception{
    public ExceptionOfGender(){}

    public void genderException(String gender){
        System.out.println("GenderException");
        System.out.printf("Warning: Not correct gender: %s", gender);
        System.out.println("Enter gender m or f ");
        System.out.println();
    }
}
