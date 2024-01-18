//importação de todos os itens da biblioteca java.sql
import java.sql.*;
//importação de todos os itens da biblioteca java.sql
import java.util.*;
// declaração da classe/objeto UpdateMySQL
public class UpdateMySQL {
    /** declaração de método executor main
     * public: porque poderá ser importado por outros objetos/classes
     * static: porque o método não poderá ser alterado ou sobrescrito
     * void porquÊ é um método sem retorno
     * @param String[] porque poderão ser invocados métodos do tipo String e matrizes []
     * @param args porque poderá ser invocado o objeto args da biblioteca java.lang
     */
    public static void main(String[] args) {
        //declaração de variável status do Tipo String, a qual será atribuído (=) o valor 'Nada aconteceu'.
        String status = "Nada aconteceu ainda.";
        //declaração da variável validLogin, update e altsenha, do tipo Boolean, que terá o valor como 'false'.
        boolean validLogin =false, update = false, altsenha = false;
        //declaração de variável resp do Tipo inteiro.
        int resp;
        //declaração da variável do tipo String como novoNome, novaSenha, novoLogin, versenha e conSenha.
        String novoNome, novaSenha, novoLogin, versenha, conSenha;
        //declaração de um novo Scanner, chamado scnVerSenha.
        Scanner scnVerSenha = new Scanner(System.in);
        //declaração de um novo Scanner, chamado scnNovaSenha.
        Scanner scnNovaSenha = new Scanner(System.in);
        //declaração de um novo Scanner, chamado scnConSenha.
        Scanner scnConSenha = new Scanner(System.in);
        //declaração de um novo Scanner, chamado scnLogin.
        Scanner scnLogin = new Scanner(System.in);
        //declaração de um novo Scanner, chamado scnSenha.
        Scanner scnSenha = new Scanner(System.in);
        //declaração de um novo Scanner, chamado scnResp.
        Scanner scnResp = new Scanner(System.in);
        //declaração da ação try.
        try {
            //declaração da ação while, para manter o loop enquanto a variável validLogin for (=) false.
            while (validLogin == false) {
            //declação da variável do objeto Connection como conn, e conectar com o objeto App.
            Connection conn = App.conectar();
            //declaração de um novo Scanner, chamado scnUpdateCadastro.
            Scanner scnUpdateCadastro = new Scanner(System.in);
            //declaração de impressão na tela com a mensagem: 'Bem vindo à tela de login.'
            System.out.println("Bem vindo à tela de login.");
            //declaração de impressão na tela com a mensagem: 'Digite o login cadastrado:'.
            System.out.println("Digite o login cadastrado: ");
            //declaração da variável do tipo String como strLogin, recebendo o valor digitado pela variável 'scnLogin' do tipo Scanner.
            String strLogin = scnLogin.nextLine();
            //declaração de impressão na tela com a mensagem: 'Digite a senha cadastrada: '.
            System.out.println("Digite a senha cadastrada: ");
            //declaração da variável do tipo String como strSenha, recebendo o valor digitado pela variável 'scnSenha' do tipo Scanner.
            String strSenha = scnSenha.nextLine();
            //declaração da variável do tipo String como strSqlSelect, recebendo o valor selecionado do conector 'mysql_connector', na tabela 'tbl_login', onde o login será igual (=) ao login digitado pelo usuário e a senha digitada pelo usuário.
            String strSqlSelect = "select * from `mysql_connector`.`tbl_login` where `login` = '" + strLogin + "' and `senha` = '" + strSenha + "';";
            //declaração da variável do tipo Statement como stmSql, recebendo o valor criado pela conexão com o Statement 'conn'.
            Statement stmSql = conn.createStatement();
            //declaração da variável do tipo ResultSet como rsSql, recebendo o valor criado pela execução com o Statement 'stmSql', nomeado como strSqlSelect.
            ResultSet rsSql = stmSql.executeQuery(strSqlSelect);
            //declaração da variável do tipo String como login, recebendo "";
            String login = "";
            //declaração da variável do tipo String como senha, recebendo "";
            String senha = "";
                //declaração da ação while, para manter o loop enquanto a variável rsSql estiver executando consecutivamente.
                while (rsSql.next()) {
                    //declaração da variável login, recebendo o valor capturado da execução da variável rsSql, no campo 'login';
                    login += rsSql.getString("login");
                    //declaração da variável senha, recebendo o valor capturado da execução da variável rsSql, no campo 'senha';
                    senha += rsSql.getString("senha");
 }              //Declaração do método if, enquanto a variável login e senha estiver sendo igual "", ele irá    declarar os seguintes códigos.
                if (login == "" || senha == "") {
                //Declaração da variável status com a seguinte mensagem "Login inválido! Tente Novamente", dando um parágrafo antes e depois da instância.
                status = "\nLogin inválido! Tente Novamente\n";
                //Impressão na tela da variável 'status'.
                System.out.println(status);
    }           //Se não estiver nas condições do método 'if', irá declarar os seguintes códigos.
                else {
                //Irá mudar a declaração da variável 'status' para (=) ''Logado em: ["+ login + "]".
                status = "Logado em: [" + login + "]";
                //Impressão na tela da variável 'status'.
                System.out.println(status);
                //Mudança da declaração da variável 'validLogin' para (=) 'true'.
                validLogin = true;
                 //declaração da ação while, para manter o loop enquanto a variável update for (=) 'false'.
                while (update==false) {
            //Impressão na tela da seguinte mensagem: 'Edição do cadastro'.
            System.out.println("\nEdição do cadastro");
            //Impressão na tela da seguinte mensagem: 'Por favor, digite '1' para se quiser editar nome', pulará um parágrafo, 'Digite 2 para editar login', pulará um parágrafo, 'Digite 3 para editar senha', pulará um paráfrafo, 'Digite 4 para sair' e pulará um parágrafo.
            System.out.println("Por favor, digite '1' para se quiser editar nome\nDigite 2 para editar login\nDigite 3 para editar senha\nDigite 4 para sair.\n");
            //Declaração da variável 'resp' do tipo int, que recebe o conteúdo digitado pelo usuário do Scanner scnResp.
            resp = scnResp.nextInt();
            //Declaração do método if, enquanto a variável 'resp' ter o conteúdo digitado (=) ser 1.
            if (resp==1) {
                //Irá mudar a variável 'altsenha' para (=) 'false' no começo desse método if, já que devido ao loop, se o usuário alterar qualquer variável (nome, senha e login), a variável 'altsenha' irá mudar para 'true'.
                altsenha=false;
                //Impressão na tela da seguinte mensagem: 'Digite o novo nome:'.
                System.out.println("Digite o novo nome:");
                //declaração da variável do tipo String como novoNome, recebendo o valor digitado no Scanner scnUpdateCadastro.
                novoNome = scnUpdateCadastro.nextLine();
                //declaração da variável do tipo String como stmSQLUpdate, recebendo o valor que irá ser alterado no conector 'mysql_connector', na tabela 'tbl_login', onde o valor  do nome será recebido da variável 'novoNome', localizado onde o login no banco de dados terá o mesmo valor do 'login' feito pelo usuário.
                String stmSQLUpdate = "UPDATE `mysql_connector`.`tbl_login` SET `nome` = '" + novoNome + "' WHERE (`login` = '" + strLogin + "')";
                //declaração da variável do tipo PreparedStatement como 'PreparedStatement', recebendo o valor criado pela conexão com o prepareStatement 'conn', nomeado como 'stmSQLUpdate'.
                PreparedStatement preparedStatement = conn.prepareStatement(stmSQLUpdate);
                //Executa a atualização da variával 'preparedStatement'.
                preparedStatement.executeUpdate();
                //Impressão na tela da seguinte mensagem: Atualização realizado com sucesso. Novo nome [ " + novoNome + " ] e pulará um parágrafo.
                System.out.println("Atualização realizado com sucesso. Novo nome [ " + novoNome + " ]\n");
                //Declaração do método if, enquanto a variável 'resp' ter o conteúdo digitado ser igual a (=) 2.
            } else if (resp==2){
                //Irá mudar a variável 'altsenha' para (=) 'false' no começo desse método if, já que devido ao loop, se o usuário alterar qualquer variável (nome, senha e login), a variável 'altsenha' irá mudar para 'true'.
                altsenha=false;
                //Impressão na tela da seguinte mensagem:'Qual o novo login:'.
                System.out.println("Qual o novo login:");
                //declaração da variável do tipo String como novoLogin, recebendo o valor digitado no Scanner scnUpdateCadastro.
                novoLogin = scnUpdateCadastro.nextLine();
                 //declaração da variável do tipo String como stmSQLUpdate, recebendo o valor que irá ser alterado no conector 'mysql_connector', na tabela 'tbl_login', onde o valor  do login será recebido da variável 'novoLogin', localizado onde o login no banco de dados terá o mesmo valor do 'login' feito pelo usuário.
                String stmSQLUpdate = "UPDATE `mysql_connector`.`tbl_login` SET `login` = '" + novoLogin + "' WHERE (`login` = '" + strLogin + "')";
                //declaração da variável do tipo PreparedStatement como 'PreparedStatement', recebendo o valor criado pela conexão com o prepareStatement 'conn', nomeado como 'stmSQLUpdate'.
                PreparedStatement preparedStatement = conn.prepareStatement(stmSQLUpdate);
                //Executa a atualização da variával 'preparedStatement'.
                preparedStatement.executeUpdate();
                //Impressão na tela da seguinte mensagem: Atualização realizado com sucesso. Novo login [ " + novoLogin + " ] e pulará um parágrafo.
                System.out.println("Atualização realizado com sucesso. Novo login [ " + novoLogin + " ]\n");
                //Declaração do método if, enquanto a variável 'resp' ter o conteúdo digitado ser igual a (=) 3.
            } else if (resp==3){
                //declaração da ação while, para manter o loop enquanto a variável altsenha for (=) 'false'.
                while (altsenha==false) {
                //Impressão na tela da seguinte mensagem: 'Digite sua Senha:'.
                System.out.println("Digite sua Senha:");
                //Declaração da variável 'versenha' do tipo int, que recebe o conteúdo digitado pelo usuário do Scanner scnVerSenha.
                versenha = scnVerSenha.nextLine();
                //Impressão na tela da seguinte mensagem:'Digite a nova senha:'.
                System.out.println("Digite a nova senha:");
                //Declaração da variável 'novaSenha' do tipo int, que recebe o conteúdo digitado pelo usuário do Scanner scnNovaSenha.
                novaSenha = scnNovaSenha.nextLine();
                //Impressão na tela da seguinte mensagem:'Repita a nova senha:'.
                System.out.println("Repita a nova senha:");
                 //Declaração da variável 'conSenha' do tipo int, que recebe o conteúdo digitado pelo usuário do Scanner scnConSenha.
                conSenha = scnConSenha.nextLine();
                //Declaração do método if, enquanto a variável 'senha' for diferente do conteúdo (!=) da variável 'versenha'.
                if (!senha.equals(versenha)) {
                    //Impressão na tela da seguinte mensagem:'Desculpe, mas você digitou sua senha errada. Tente novamente!'.
                    System.out.println("Desculpe, mas você digitou sua senha errada. Tente novamente!");
                }
                //Declaração do outro método if, enquanto a variável 'novaSenha' for diferente do conteúdo (!=) da variável 'conSenha'.
                else if (!novaSenha.equals(conSenha)) {
                    //Impressão na tela da seguinte mensagem:'Você não repetiu a senha de maneira igual. Por favor digite novamente!'.
                    System.out.println("Você não repetiu a senha de maneira igual. Por favor digite novamente!");
                }
                //Declaração do outro método if, enquanto a variável 'versenha' for igual ao conteúdo (=) da variável 'senha' e a variável 'conSenha' for igual ao conteúdo (=) da variável 'novaSenha'.
                else if (versenha.equals(senha) || conSenha.equals(novaSenha)) {
                //declaração da variável do tipo String como stmSQLUpdate, recebendo o valor que irá ser alterado no conector 'mysql_connector', na tabela 'tbl_login', onde o valor  da senha será recebido da variável 'novaSenha', localizado onde o login no banco de dados terá o mesmo valor do 'login' feito pelo usuário.    
                String stmSQLUpdate = "UPDATE `mysql_connector`.`tbl_login` SET `senha` = '" + novaSenha + "' WHERE (`login` = '" + strLogin + "')";
                //declaração da variável do tipo PreparedStatement como 'PreparedStatement', recebendo o valor criado pela conexão com o prepareStatement 'conn', nomeado como 'stmSQLUpdate'.
                PreparedStatement preparedStatement = conn.prepareStatement(stmSQLUpdate);
                //Executa a atualização da variával 'preparedStatement'.
                preparedStatement.executeUpdate();
                //Impressão na tela da seguinte mensagem: Atualização realizado com sucesso. Nova senha [ " + novaSenha + " ] e pulará um parágrafo.
                System.out.println("Atualização realizado com sucesso. Nova senha [ " + novaSenha + " ]\n");
                //Troca o conteúdo da variável altsenha para (=) 'true', para que o loop da alteração de senha acabe (line 126).
                altsenha=true;
            }
            }
            //Declaração do método if, enquanto a variável 'resp' ter o conteúdo digitado (=) ser 4.
            } else if (resp ==4) {
                //Impressão na tela da seguinte mensagem: 'Volte sempre' e o conteúdo da variável login.
                System.out.println("\nVolte sempre " + login); 
                //Troca o conteúdo da variável update para (=) 'true', para que o loop das alterações acabe (line 84).
                update =true;
            }
            //Se não estiver nas condições do método 'if', irá declarar os seguintes códigos.
            else {
                //Impressão na tela da seguinte mensagem: 'Ocorreu um erro. Tente Novamente!' e pulará um parágrafo.
                System.out.println("Ocorreu um erro. Tente Novamente!\n");
            }
        }
        //fecha o Scanner nomeado como 'stmSql'.
        stmSql.close();
        //fecha o Scanner nomeado como 'rsSql'.
        rsSql.close();
    }
    //fecha o Scanner nomeado como 'scnUpdateCadastro'.
    scnUpdateCadastro.close();
}
    //fecha o Scanner nomeado como 'scnLogin'.
    scnLogin.close();
    //fecha o Scanner nomeado como 'scnResp'.
    scnResp.close();
    //fecha o Scanner nomeado como 'scnSenha'.
    scnSenha.close();
    //fecha o Scanner nomeado como 'scnConSenha'.
    scnConSenha.close();
     //fecha o Scanner nomeado como 'scnNovaSenha'.
    scnNovaSenha.close();
    //fecha o Scanner nomeado como 'scnVerSenha'.
    scnVerSenha.close();}
        //fechamento da ação 'try', a ação 'catch' com operação lógica 'Exception' atribuída na variável 'e', que captura erros durante a execução do programa.
        catch (Exception e) {
            //Impressão na tela da seguinte mensagem: 'Ops! Ocorreu o erro' e o conteúdo da variável 'e'.
 System.out.println("Ops! Ocorreu o erro " + e);
 } //fechamento da chave da ação 'catch'.
    } //fechamento do método executor 'main'.
} //fechamento do objeto 'UpdateMySQL'.

    

