package view;
//TODO: for maksim to adapt his part
public enum FxmlView {
    ENTERTAINMENT_MENU {
        @Override
        public String getTitle() {
            return "Entertainment Menu";
        }
        @Override
        public String getFxmlFile() {
            return "EntertainmentMenu.fxml";
        }
    },
    SERVICE_MENU {
        @Override
        public String getTitle() {
            return "Service Menu";
        }
        @Override
        public String getFxmlFile() {
            return "ServiceMenu.fxml";
        }
    },
    MOVIE_MENU {
        @Override
        public String getTitle() {
            return "Movie Menu";
        }
        @Override
        public String getFxmlFile() {
            return "MovieMenu.fxml";
        }
    };

    public abstract String getTitle();
    public abstract String getFxmlFile();
}
