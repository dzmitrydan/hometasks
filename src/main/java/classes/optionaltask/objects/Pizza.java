package classes.optionaltask.objects;

public class Pizza {

    private String namePizza;
    private Ingredient[] ingredients;
    private String typePizza = "";
    private int quantity;

    public Pizza(String namePizza, Ingredient[] ingredients, String typePizza, int quantity) {
        this.namePizza = namePizza;
        this.ingredients = ingredients;
        this.typePizza = typePizza;
        this.quantity = quantity;
    }

    public Pizza(String namePizza, int quantity) {
        this.namePizza = namePizza;
        this.quantity = quantity;
    }

    public Pizza() {
    }

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getTypePizza() {
        return typePizza;
    }

    public void setTypePizza(String typePizza) {
        this.typePizza = typePizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
