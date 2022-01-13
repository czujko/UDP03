import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPenvioDatagrama {
    public static void main(String[] argv) throws Exception {
        Scanner sc = new Scanner(System.in);
        int port = 12345; //puerto por el que escucha el proceso que va a recibir el mensaje
        InetAddress destino = InetAddress.getLocalHost();
        System.out.println("Introduce IP destino");//IP host
        String ipDestino = sc.nextLine();
        destino=InetAddress.getByName(ipDestino); //Por si queremos enviar a una IP concreta

        byte[] mensaje = new byte[1024]; //matriz de bytes


        System.out.println("Introduce el mensaje que quieres enviar: ");
        String mensaje_a_enviar = sc.nextLine();
        String saludo = mensaje_a_enviar; //mensaje a enviar
        mensaje = saludo.getBytes();  //codificarlo a bytes para enviarlo

        //construyo el datagrama a enviar por eso uso el constructor de los cuatro parámetros
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

        DatagramSocket socket = new DatagramSocket(12345);
        socket.send(envio);//envio datagrama a destino y port

        socket.close();

    }
}

   