package model;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //初始化各车型属性,多态，父类对象指向子类
        Car benChi = new BenChi();
        benChi.setName("奔驰");
        benChi.setHum(5);
        benChi.setPrice(60000);
        Car mazd = new Mazd();
        mazd.setName("马自达");
        mazd.setHum(10);
        mazd.setPrice(10000);

        System.out.println("======= 欢迎进入达达租车系统 =======");
        System.out.println("是否进行租车：0.是  1.否");
        Scanner sc1 = new Scanner(System.in);
        int flag = sc1.nextInt();
        if(flag == 1)
        {
            System.out.println("欢迎下次再来！");
            return;
        }
        else if(flag == 0)
        {
            System.out.println("请根据需要选择以下车型：");
            System.out.println("序号\t汽车名称\t\t租金\t\t容量");
            System.out.println("1.\t"+benChi.getName()+"\t\t"+benChi.getPrice()
                    +"元/每天\t载人："+benChi.getHum()+"人");//\t跳至下一制表符
            System.out.println("2.\t"+mazd.getName()+"\t\t"+mazd.getPrice()
                    +"元/每天\t载人："+mazd.getHum()+"人");

            System.out.println("=======请输入您要租的数量=======");
            Scanner sc2 = new Scanner(System.in);
            int num = sc2.nextInt();
            double TotalPrice = 0;//总价格
            int Totalcapa = 0;//总载货量
            double Totalhum = 0;//总载人量
            String[] a = new String[2];
            for(int i = 1;i <= num;i ++)
            {
                Scanner sc3 = new Scanner(System.in);
                int order = sc3.nextInt();
                switch(order)
                {
                    case 1:
                        TotalPrice += benChi.getPrice();
                        Totalhum +=benChi.getHum();
                        a[0] = benChi.getName();
                        break;
                    case 2:
                        TotalPrice += mazd.getPrice();
                        Totalhum +=mazd.getHum();
                        a[1] = mazd.getName();
                        break;

                }

            }

            System.out.println("=======输入你要租的天数=======");
            Scanner sc4 = new Scanner(System.in);
            int n = sc4.nextInt();
            TotalPrice *= n;

            System.out.println("**********您的账单***********");
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < a.length;i++){
                if(a[i] != null && (i < 3||i == 5)){ //编号为0,1,2,6的车可以载人
                    builder.append(a[i]+"\t");
                }
            }
            if(builder.length()!=0)
            {
                System.out.println("可载人的车有：");
                System.out.println(builder+"\n共载人："+Totalhum+"人\n");
            }
            StringBuilder builder2 = new StringBuilder();
            for(int i = 0;i<a.length;i++){
                if(a[i] != null && i>3){//编号为3,4,5的车可以载货
                    builder2.append(a[i]+"\t");
                }
            }
            if(builder2.length()!=0){
                System.out.println("可载货的车有：");
                System.out.println(builder2+"\n共载货："+Totalcapa+"吨\n");

            }
            System.out.println("租车的总价格为："+TotalPrice+"元");
        }else{
            System.out.println("输入类错误");

        }

    }

}

