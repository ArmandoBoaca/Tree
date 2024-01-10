import java.io.File;

public class Tree {
    private File file;

    public Tree(File file) {
        this.file = file;
    }

    // FUnzione ricorsiva per implementazione
    public void display(int x){
        System.out.print("|");
        for (int i = 0; i < x; i++) {
            System.out.print("___");


        }
        System.out.println(file.getName());

        if (file.isDirectory()){
            File[] figli = file.listFiles();
            if (figli != null){
                for (File figlio : figli){
                    Tree nodoFiglio = new Tree(figlio);
                    nodoFiglio.display(x + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Tree <path>");
            System.exit(1);
        }

        String rootPath = args[0];
        File rootFile = new File(rootPath);

        if (!rootFile.exists()) {
            System.out.println("Cartella non esistente.");
            System.exit(1);
        }

        if (!rootFile.isDirectory()) {
            System.out.println("Non è una directory.");
            System.exit(1);
        }

        Tree rootNode = new Tree(rootFile);
        rootNode.display(0);

    }

}