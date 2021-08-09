public class App {
    public static void main(String[] args) throws Exception {
        
        Tortas[] Tortas2 = new Tortas[4];
        Tortas2[0] = new Tortas();
        Tortas2[1] = new Tortas("naranja","una_libra",23000.0);
        Tortas2[2] = new Crema("vainilla","media_libra",25000.0, false);
        Tortas2[3] = new Fondant("chispas","una_libra",23000.0, "figura3D");
        ValorTotal respuesta2 = new ValorTotal(Tortas2);
        respuesta2.mostrarTotales();
        System.out.println();
        
            
           }
           
    }
    

    class Tortas {
        // Constantes
        protected final static Double PRECIOBASE = 20000.0;
        private final static String SABOR="vainilla";
        private final static String TAMANO="media_libra";
        // Atributos
        protected String sabor;
        protected String tamano;
        private Double precioBase;
        // Constructores
        public Tortas(String sabor, String tamano, Double precioBase) {
            this.sabor = sabor;
            this.tamano = tamano;
            this.precioBase = precioBase;
        }

        public Tortas() {
            this.sabor = SABOR;
            this.tamano = TAMANO;
            this.precioBase = PRECIOBASE;
        }
        //Métodos
        public double calcularPrecio() {
            
            int precioFinal = 0;

            // Sabor
            if( sabor.equals("vainilla")){
                precioFinal += precioBase * 1.1;
            }else if( sabor.equals("naranja")){
                precioFinal += precioBase * 1.2;
            }else if( sabor.equals("chispas")){
                precioFinal += precioBase * 1.3;
            }else if( sabor.equals("relleno_arequipe")){
                precioFinal += precioBase * 1.4;
            }
            // Tamaño
            if( tamano.equals("media_libra")){
                precioFinal += 5000;
            }else if( tamano.equals("una_libra")){
                precioFinal += 15000;
            }
            return precioFinal;
        }

        public Double getPreciobase() {
            return precioBase;
        }
        public String getSabor() {
            return sabor;
        }
        public void setSabor(String sabor) {
            this.sabor = sabor;
        }
        public String getTamano() {
            return tamano;
        }
        public void setTamano(String tamano) {
            this.tamano = tamano;
        }
       
        public void setPrecioBase(Double precioBase) {
            this.precioBase = precioBase;
        }

       
       }
       class Crema extends Tortas {
        // Atributos
        private Boolean cremaToppings;

        @Override
        public Double getPreciobase() {
            // TODO Auto-generated method stub
            return super.getPreciobase();
        }

        public Boolean getCremaToppings() {
            return cremaToppings;
        }

        public void setCremaToppings(Boolean cremaToppings) {
            this.cremaToppings = cremaToppings;
        }

        // Métodos
        @Override
        public double calcularPrecio() {
            int precioFinal = 0;

            // Sabor
            if( sabor.equals("vainilla")){
                precioFinal += getPreciobase() * 1.1;
            }else if( sabor.equals("naranja")){
                precioFinal += getPreciobase() * 1.2;
            }else if( sabor.equals("chispas")){
                precioFinal += getPreciobase() * 1.3;
            }else if( sabor.equals("relleno_arequipe")){
                precioFinal += getPreciobase() * 1.4;
            }
            // Tamaño
            if( tamano.equals("media_libra")){
                precioFinal += 5000;
            }else if( tamano.equals("una_libra")){
                precioFinal += 15000;
            }
            if (cremaToppings == true){
                precioFinal += 10000;
            }else{
                precioFinal += 5000;
            }
            return precioFinal;
        
        }

        public Crema(String sabor, String tamano, Double precioBase, Boolean cremaToppings) {
            super(sabor, tamano, precioBase);
            this.cremaToppings = cremaToppings;
        }
       }
       class Fondant extends Tortas {
        // Atributos
        private String fondantEstilo;
        // Constructores
        public Fondant(String sabor, String tamano, Double precioBase, String fondantEstilo) {
            super(sabor, tamano, precioBase);
            this.fondantEstilo = fondantEstilo;
        }
        // Métodos
        @Override
        public double calcularPrecio() {
            int precioFinal = 0;
            // Sabor
            if( sabor.equals("vainilla")){
                precioFinal += getPreciobase() * 1.1;
            }else if( sabor.equals("naranja")){
                precioFinal += getPreciobase() * 1.2;
            }else if( sabor.equals("chispas")){
                precioFinal += getPreciobase() * 1.3;
            }else if( sabor.equals("relleno_arequipe")){
                precioFinal += getPreciobase() * 1.4;
            }
            // Tamaño
            if( tamano.equals("media_libra")){
                precioFinal += 5000;
            }else if( tamano.equals("una_libra")){
                precioFinal += 15000;
            }
            if (fondantEstilo.equals("figura2D")){
                precioFinal += 15000;
            }else{
                precioFinal += 30000;
            }
            return precioFinal;
        }

        
       }
       class ValorTotal {
        // Atributos
        private Double valorTotalTortas = 0.00;
        private Double valorTotalTortasCrema = 0.00;
        private Double valorTotalTortasFondant = 0.00;
        private Tortas[] tortas;
        // Constructores
        public ValorTotal(Tortas[] tortas) {
            this.tortas = tortas;
        }
        
        
        // Métodos
        public void mostrarTotales() {
        // Cálculo totales
        for(int i = 0 ; i < tortas.length ; i++){
            if(tortas[i] instanceof Crema){
                valorTotalTortasCrema += tortas[i].calcularPrecio();
            }else if(tortas[i] instanceof Fondant){
                valorTotalTortasFondant += tortas[i].calcularPrecio();
            }else if( tortas[i] instanceof Tortas){
                valorTotalTortas += tortas[i].calcularPrecio();
            }

        }
        System.out.println(Math.round(valorTotalTortas));
        System.out.println(Math.round(valorTotalTortasCrema));
        System.out.println(Math.round(valorTotalTortasFondant));
        System.out.println(Math.round(valorTotalTortas + valorTotalTortasCrema + valorTotalTortasFondant));
        }

        
       }