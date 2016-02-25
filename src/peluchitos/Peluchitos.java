/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluchitos;

import java.util.Scanner;

/**
 *
 * @author Tatiana
 */
public class Peluchitos {
   private String producto;
   private int cantidad;
   private int valor;
   private int venta = 1;

    public int getVenta() {
        return venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
   
   
   void agregarProducto(String p, int c, int v){
       producto = p;
       cantidad = c;
       valor = v;
       
       //System.out.println("\n===============================================\nNombre: "+producto+"\nCantidad: "+cantidad+"\nValor del producto: "+valor);
   }
   
   void buscarProducto(){
       System.out.println("\n===============================================\nNombre: "+producto+"\nCantidad: "+cantidad+"\nValor del producto: "+valor);
   }
   
   void ventaProducto(int numC){
       cantidad = cantidad - numC;
       venta = venta * numC;
   }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sel;
        int i = 0;
        boolean flag = false;
        Scanner in = new Scanner(System.in);
        Peluchitos pro[] = new Peluchitos[100];
        
        do{
            System.out.println("===============================================\n1.Agregar Producto\n2.Buscar Producto\n3.Eliminar Producto\n4.Mostrar Inventario\n5.Realizar Venta\n6.Mostrar Ganancias Totales\n7.Salir");
            sel = in.nextInt();
            System.out.println("===============================================\n");
            in.nextLine(); //Limpia el buffer

            switch(sel){
                case 1:
                    pro[i] = new Peluchitos();
                    System.out.println("Ingrese el nombre del producto: ");
                    String n = in.nextLine();
                    System.out.println("Ingrese la cantidad a almacenar: ");
                    int c = in.nextInt();
                    in.nextLine();
                    System.out.println("Ingrese el valor por unidad del producto: ");
                    int v = in.nextInt();
                    in.nextLine();
                    
                    pro[i].agregarProducto(n, c, v);
                    i++;

                    break;
                case 2:
                    System.out.println("Ingrese el producto a buscar: ");
                    String bus = in.nextLine();
                    
                    for(int h=0; h<i; h++){
                        if(bus.equals(pro[h].getProducto())){
                            System.out.println("El producto se encuentra en almacen: \n");
                            pro[h].buscarProducto();
                            break;
                        }
                        else{
                            System.out.println("El producto no se encuentra en almacen, buscado en posicion "+h);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite el nombre del producto que desea eliminar: ");
                    String bus2 = in.nextLine();
                    
                    for(int h=0; h<i; h++){
                        if(bus2.equals(pro[h].getProducto())){
                            pro[h].setCantidad(0);
                            pro[h].setProducto("Vacio");
                            pro[h].setValor(0);
                        
                            System.out.println("Producto Borrado\n");
                        }
                        else{}
                        
                    
                    }
                    break;
                    
                case 4:
                    System.out.println("Inventario:\n");
                    for(int h=0; h<i; h++){
                        //System.out.println("Hasta aqui bien");
                        pro[h].buscarProducto();
                    }

                    break;
                case 5:
                    System.out.println("Ingrese el producto a vender: ");
                    String bus3 = in.nextLine();
                    int numC;
                    for(int h=0; h<i; h++){
                        if(bus3.equals(pro[h].getProducto())){
                            System.out.println("Producto encontrado, digite la cantidad a vender menor a "+ pro[h].getCantidad()+" :");
                            numC = in.nextInt();
                            in.nextLine();
                            pro[h].ventaProducto(numC);
                            
                        }
                        else{
                            
                        }
                    }

                    break;
                case 6:
                    int ganancia = 0;
                    for(int h=0; h<i; h++){
                        ganancia = ganancia + (pro[h].getValor() * pro[h].getVenta());
                    }
                    System.out.println("Ganancias Totales: "+ganancia+"\n");
                    

                    break;
                case 7:
                    flag = true;
                    break;
            }
        }while(flag != true);
    }
    
}
