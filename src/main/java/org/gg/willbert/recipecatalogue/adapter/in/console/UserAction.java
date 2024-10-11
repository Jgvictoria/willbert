package org.gg.willbert.recipecatalogue.adapter.in.console;

public enum UserAction {

    f("Find recipe (f)"),
    i("Import recipes from file (i)"),
    q("Quit (q)");

    private final String label;

    UserAction(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public static String toPrintableActions() {
        StringBuilder summary = new StringBuilder();
        for (UserAction value : UserAction.values()) {
            summary.append(String.format("%s%n", value.getLabel()));
        }

        return summary.toString();
    }

}
