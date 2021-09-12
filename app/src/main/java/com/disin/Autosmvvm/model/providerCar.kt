package com.disin.Autosmvvm.model

class providerCar {


    companion object {

        fun providerListCar(): ArrayList<Auto> {

            var list: ArrayList<Auto> = ArrayList()

            list.add(Auto(1, "red", "Toyota", 2020, "Sedan"))
            list.add(Auto(2, "green", "Kia", 2021, "Sport"))
            list.add(Auto(3, "blue", "Suzuki", 2014, "Sedan"))
            list.add(Auto(4, "yellow", "Nissan", 2019, "Hachback"))
            list.add(Auto(5, "red", "MG", 2013, "Sedan"))

            return list

        }




        fun providerlistTypeCar():ArrayList<String>{

            var list:ArrayList<String> = ArrayList()

            list.add("Seleccione una opcion")
            list.add("Sedan")
            list.add("Hachback")
            list.add("Sport")

            return list
        }


        fun providerlistColorcar():ArrayList<String>{

            var list:ArrayList<String> = ArrayList()

            list.add("Seleccione una opcion")
            list.add("red")
            list.add("green")
            list.add("blue")
            list.add("yellow")

            return list
        }
    }




}