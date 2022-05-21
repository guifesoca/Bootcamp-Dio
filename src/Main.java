import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Curso curso1_java = new Curso();
        curso1_java.setTitulo("curso java");
        curso1_java.setDescricao("descrição curso java");
        curso1_java.setCargaHoraria(8);

        Curso curso2_java = new Curso();
        curso2_java.setTitulo("curso js");
        curso2_java.setDescricao("descrição curso js");
        curso2_java.setCargaHoraria(4);

        Mentoria mentoria_java = new Mentoria();
        mentoria_java.setTitulo("mentoria de java");
        mentoria_java.setDescricao("descrição mentoria java");
        mentoria_java.setData(LocalDate.now());

        Bootcamp bootcamp_java = new Bootcamp();
        bootcamp_java.setNome("Bootcamp Java Developer");
        bootcamp_java.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp_java.getConteudos().add(curso1_java);
        bootcamp_java.getConteudos().add(curso2_java);
        bootcamp_java.getConteudos().add(mentoria_java);

        Curso curso_python = new Curso();
        curso_python.setTitulo("curso python");
        curso_python.setDescricao("descrição curso python");
        curso_python.setCargaHoraria(6);

        Mentoria mentoria_python = new Mentoria();
        mentoria_python.setTitulo("mentoria de python");
        mentoria_python.setDescricao("descrição mentoria python");
        mentoria_python.setData(LocalDate.now());

        Bootcamp bootcamp_python = new Bootcamp();
        bootcamp_python.setNome("Bootcamp Python Developer");
        bootcamp_python.setDescricao("Descrição Bootcamp Python Developer");
        bootcamp_python.getConteudos().add(curso_python);
        bootcamp_python.getConteudos().add(mentoria_python);

        Scanner sn = new Scanner(System.in);
        System.out.println("Olá Dev! Digite seu nome:");
        String nome = sn.nextLine();
        Dev novoDev = new Dev();
        novoDev.setNome(nome);

        int opcao = 0;
        do {
            Scanner so = new Scanner(System.in);
            System.out.println("Qual Bootcamp deseja fazer? 1- Java Developer; 2- Python Developer.");
            opcao = so.nextInt();
        } while(opcao < 1 || opcao > 2);

        if(opcao == 1) {
            novoDev.inscreverBootcamp(bootcamp_java);
        }
        
        else if(opcao == 2) {
            novoDev.inscreverBootcamp(bootcamp_python);
        }

        while(novoDev.getConteudosInscritos().size() > 0) {
            System.out.println("Conteúdos Inscritos " + novoDev.getNome() + ":" + novoDev.getConteudosInscritos());
            System.out.println("XP:" + novoDev.calcularTotalXp());
            Scanner sc = new Scanner(System.in);
            System.out.println("Tecle enter quando concluído o atual conteúdo.");
            sc.nextLine();
            novoDev.progredir();
            System.out.println("Conteúdos Concluídos " + novoDev.getNome() + ":" + novoDev.getConteudosConcluidos());
        }

        System.out.println("Parabéns " + novoDev.getNome() + ". Você concluiu todo o conteúdo.");

    }

}
