package com.exam;
package ;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        
        int choix;
        Scanner cs=new Scanner(System.in);
        DataBase dataBase=new MysqlImpl();
        ClasseRepository classeRepository=new ClasseRepositoryImpl(dataBase);
        ClasseService classeService=new ClasseServiceImpl(classeRepository);


        ModuleRepository moduleRepository=new ModuleRepositoryImpl(dataBase);
        ModuleService moduleService=new ModuleServiceImpl(moduleRepository);
        
        
        
        SalleRepository salleRepository=new SalleRepositoryImpl(dataBase);
        SalleService salleService=new SalleServiceImpl(salleRepository);

        ProfesseurRepository professeurRepository= new ProfesseurRepositoryImpl(dataBase);
        ProfesseurService professeurService= new ProfesseurServiceImpl(professeurRepository);
        
        Classe_ModuleRepository classe_ModuleRepository=new Classe_ModuleRepositoryImpl(dataBase);
        Classe_ModuleService classe_ModuleService=new Classe_ModuleServiceImpl(classe_ModuleRepository);

        Classe_ProfesseurRepository classe_ProfesseurRepository=new Classe_ProfesseurRepositoryImpl(dataBase);
        Classe_ProfesseurService classe_ProfesseurService= new Classe_ProfesseurServiceImpl(classe_ProfesseurRepository);
        
        CoursRepository coursRepository= new CoursRepositoryImpl(dataBase);
        CoursService coursService= new CoursServiceImpl(coursRepository, classeRepository, professeurRepository, moduleRepository, salleRepository);
       
        do {
            System.out.println("1-Gerer  classe");
            System.out.println("2-Gerer  module");
            System.out.println("3-Gerer Professeur");
            System.out.println("4-Gerer Salle");
            System.out.println("5-Affecter un Module a une Classe");
            System.out.println("6-Lister les modules d'une Classe");
            System.out.println("7-Affecter un Professeur a une Classe");
            System.out.println("8-Lister les professeur d'une Classe");
            System.out.println("9-Planifier un Cours");
            System.out.println("10-Lister Les Cours Planifier");
            System.out.println("11-Lister les Cours d'une Classe");
            System.out.println("12-Lister les cours d'un professeur");



            System.out.println("13-Quitter");
            System.out.println("Entrer votre choix ?");
                choix=cs.nextInt();
                switch (choix) {
                case 1 :
                        dataBase.clearScreen();
                        do {
                            System.out.println("1-Ajouter une classe");
                            System.out.println("2-Lister les classes");
                            System.out.println("3-Modifier une classe");
                            System.out.println("4-Lister les classes Archiver ");
                            System.out.println("5-Retour");
                           
                            System.out.println("Entrer votre choix ?");
                            choix=cs.nextInt();
                            switch (choix) { 
                              case 1:
                                  cs.nextLine();
                                  System.out.println("Choisir une Filiere");
                                  classeService.listerFiliere().forEach(System.out::println);
                                  int idFiliere=cs.nextInt();

                                  System.out.println("Choisir une Niveaux");
                                  classeService.listerNiveaux().forEach(System.out::println);
                                  int idNiveau=cs.nextInt();
                                  System.out.println("Choisir si la classe doit etre archiver ou non ");
                                  classeService.listeriIsArchiveds().forEach(System.out::println);
                                  int isArchive=cs.nextInt();



                                 isArchived archive_select=classeService.listeriIsArchiveds().get(isArchive);
                                 Filiere filiereSelect=classeService.listerFiliere().get(idFiliere-1);
                                 Niveau niveauSelect=classeService.listerNiveaux().get(idNiveau-1);
                                 String nomCl=String.format("%s %s",niveauSelect.getLibelle(),filiereSelect.getLibelle());
                                
                                  Classe classe=new Classe(0,nomCl,niveauSelect.getLibelle(),filiereSelect.getLibelle(),archive_select.getLibelle());
                                  if(classeService.ajouterClasse(classe)){
                                      System.out.println("Classe enregister avec success");
                                  }else{
                                      System.out.println("Erreur insertion");
                                  }
                              break;

                              case 2:
                                     cs.nextLine();
                                     System.out.println("Voila la Liste des Classe Existante ");
                                     classeService.listerClasse().forEach(System.out::println);
                              break;
                              case 3:
                                cs.nextLine();
                                System.out.println("Voila la Liste des Classe Existante ");
                                classeService.listerClasse().forEach(System.out::println);
                                System.out.println("Entrer l'id de la classe ");
                                int idMod=cs.nextInt();

                                System.out.println("Choisir une Filiere");
                                classeService.listerFiliere().forEach(System.out::println);
                                int filiereMod=cs.nextInt(); 

                                System.out.println("Choisir une Niveaux");
                                classeService.listerNiveaux().forEach(System.out::println);
                                int niveau_Mod=cs.nextInt();


                                System.out.println("Choisir si la classe doit etre archiver ou non ");
                                classeService.listeriIsArchiveds().forEach(System.out::println);
                                int isArchivee=cs.nextInt();

                                isArchived archived_select=classeService.listeriIsArchiveds().get(isArchivee-1);
                                Filiere filiere_selcet=classeService.listerFiliere().get(filiereMod-1);
                                Niveau niveau_select=classeService.listerNiveaux().get(niveau_Mod-1);
                                String nomCl_Mod=String.format("%s %s",niveau_select.getLibelle(),filiere_selcet.getLibelle());
                                
                                
                                classeService.ModifierClasse(idMod,nomCl_Mod,niveau_select.getLibelle(),filiere_selcet.getLibelle(),archived_select.getLibelle());
                              break;
                              case 4:
                                     cs.nextLine();
                                     System.out.println("Voici la liste des classe archiver");
                                     classeService.listerClasseArchiveds(1).forEach(System.out::println);
                              break;
                            }
                          }while(choix!=5);
            break;
            case 2:
                    dataBase.clearScreen();
                    do {
                        System.out.println("1-Ajouter un Module");
                        System.out.println("2-Lister les Module");
                        System.out.println("3-Modifier un Module");
                        System.out.println("4-Lister les Modules Archiver ");
                        System.out.println("5-Retour");
                        
                        System.out.println("Entrer votre choix ?");
                        choix=cs.nextInt();
                        switch (choix) { 
                            case 1:
                                cs.nextLine();
                                System.out.println("Entrer le Nom Du Module ");
                                String libelle_Module=cs.nextLine();
                                
                                System.out.println("Entrer le nombre d'heure du Module ");
                                int nmbre_Heure_Module;
                                while (true) {
                                    try {
                                        nmbre_Heure_Module = Integer.parseInt(cs.nextLine());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Veuillez entrer un nombre valide pour les heures.");
                                    }
                                }
                            
                                System.out.println("Entrer le Coefficient du Module ");
                                int coefficient_Module;
                                while (true) {
                                    try {
                                        coefficient_Module = Integer.parseInt(cs.nextLine());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Veuillez entrer un nombre valide pour le coefficient.");
                                    }
                                }
                                System.out.println("Choisir si le module doit etre archiver ou non ");
                                moduleService.listeriIsArchiveds().forEach(System.out::println);
                                int isArchive=cs.nextInt();


                                    Module module= new Module(0,libelle_Module , nmbre_Heure_Module, coefficient_Module,isArchive);
                                if(moduleService.ajouterModule(module)){
                                      System.out.println("Module ajouter avec success");
                                }else{
                                      System.out.println("Erreur insertion");
                                  }

                            break;
                            case 2:
                                    cs.nextLine();
                                    System.out.println("Voila la Liste des Modules Existante ");
                                    moduleService.listerModules().forEach(System.out::println);
                            break;
                            case 3:
                                cs.nextLine();
                                System.out.println("Voila la Liste des Modules Existante ");
                                moduleService.listerModules().forEach(System.out::println);
                                System.out.println("Entrer l'id du module ");
                                int idMod=cs.nextInt();
                                cs.nextLine();
                                System.out.println("Entrer le Nom Du Module ");
                                String libel_Module=cs.nextLine();

                                
                                System.out.println("Entrer le nombre d'heure du Module ");
                                int nbre_Heure_Module;
                                while (true) {
                                    try {
                                        nbre_Heure_Module = Integer.parseInt(cs.nextLine());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Veuillez entrer un nombre valide pour les heures.");
                                    }
                                }
                            
                                System.out.println("Entrer le Coefficient du Module ");
                                int coeficient_Module;
                                while (true) {
                                    try {
                                        coeficient_Module = Integer.parseInt(cs.nextLine());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Veuillez entrer un nombre valide pour le coefficient.");
                                    }
                                }
                                                                 
                                System.out.println("Choisir si le module doit etre archiver ou non ");
                                moduleService.listeriIsArchiveds().forEach(System.out::println);
                                int isArchivee=cs.nextInt();

                                moduleService.ModifierModule(idMod, libel_Module, nbre_Heure_Module, coeficient_Module,isArchivee);

                                break;
                                case 4:
                                     cs.nextLine();
                                     System.out.println("Voici la liste des Modules archiver");
                                     moduleService.listerModuleArchiveds(1).forEach(System.out::println);
                              break;
                        }
                    }while(choix!=5);
            break;   
           case 3 :
                        dataBase.clearScreen();
                        do {
                            System.out.println("1-Ajouter un Professeur");
                            System.out.println("2-Lister tous les profs");
                            System.out.println("3-Modifier un profs");
                            System.out.println("4-Lister les profs Archiver ");
                            System.out.println("5-Retour");
                           
                            System.out.println("Entrer votre choix ?");
                            choix=cs.nextInt();
                            switch (choix) { 
                              case 1:
                                cs.nextLine();
                                System.out.println("Entrer le Nom Du prof ");
                                String libelle_profs=cs.nextLine();

                                System.out.println("Choisir un Grade");
                                professeurService.listerGrades().forEach(System.out::println);
                                int idGrade=cs.nextInt();

                                System.out.println("Choisir si le prof doit etre archiver ou non ");
                                professeurService.listeriIsArchiveds().forEach(System.out::println);
                                int isArchive=cs.nextInt();

                                Grade gradeSelect=professeurService.listerGrades().get(idGrade-1);

                                String emailSelect=libelle_profs+"@gmail.com";
                                

                                isArchived archive_select=professeurService.listeriIsArchiveds().get(isArchive);
                                
                                Professeur professeur=new Professeur(0,libelle_profs,gradeSelect.getLibelle(),emailSelect,archive_select.getLibelle());
                                if(professeurService.ajouterProfesseur(professeur)){
                                      System.out.println("professeur Ajouter avec success");
                                }else{
                                      System.out.println("Erreur insertion");
                                }
                              break;

                              case 2:
                                     cs.nextLine();
                                     System.out.println("Voila la Liste des Professeur Existante ");
                                     professeurService.listerProfesseurs().forEach(System.out::println);
                              break;
                              case 3:
                                cs.nextLine();
                                System.out.println("Voila la Liste des Professeur Existante ");
                                professeurService.listerProfesseurs().forEach(System.out::println);
                                System.out.println("Entrer l'id du prof ");
                                int idProf=cs.nextInt();

                                cs.nextLine();

                                System.out.println("Entrer le Nom Du prof ");
                                String libele_profs=cs.nextLine();

                                System.out.println("Choisir un Grade");
                                professeurService.listerGrades().forEach(System.out::println);
                                int idGradee=cs.nextInt();

                                System.out.println("Choisir si le prof doit etre archiver ou non ");
                                professeurService.listeriIsArchiveds().forEach(System.out::println);
                                int isArchivee=cs.nextInt();

                                Grade gradSelect=professeurService.listerGrades().get(idGradee-1);

                                String emailSelecct=libele_profs+"@gmail.com";
                                
                                
                                professeurService.ModifierProfesseur(idProf, libele_profs, gradSelect.getLibelle(), emailSelecct, isArchivee);
                              break;
                              case 4:
                                     cs.nextLine();
                                     System.out.println("Voici la liste des professeurs archiver");
                                     professeurService.listerProfesseurArchiveds(1).forEach(System.out::println);
                              break;
                            }
                          }while(choix!=5);
            break;
            case 4:
                        dataBase.clearScreen();
                        do {
                            System.out.println("1-Ajouter une Salle");
                            System.out.println("2-Lister toute les Salles");
                            System.out.println("3-Modifier une salle");
                            System.out.println("4-Lister les Salle Disponible ");
                            System.out.println("5-Retour");
                           
                            System.out.println("Entrer votre choix ?");
                            choix=cs.nextInt();
                            switch (choix) { 
                              case 1:
                                cs.nextLine();
                                System.out.println("Entrer le Nom de la Salle ");
                                String libelle_salle=cs.nextLine();
                                cs.nextLine();

                                System.out.println("Entrer la capacite de la Salle ");
                                int capacite=cs.nextInt();

                                System.out.println("Choisir si la Salle doit etre Disponible ou non ");
                                salleService.listerIsDisponible().forEach(System.out::println);
                                int isDisponible=cs.nextInt();


                                

                                isDisponible archive_select=salleService.listerIsDisponible().get(isDisponible);
                                
                                Salle salle=new Salle(0,libelle_salle,capacite,archive_select.getLibelle());
                                if(salleService.ajouterSalle(salle)){
                                      System.out.println("Salle Ajouter avec success");
                                }else{
                                      System.out.println("Erreur insertion");
                                }
                              break;

                              case 2:
                                     cs.nextLine();
                                     System.out.println("Voila la Liste des Salle Existante ");
                                     salleService.listerSalles().forEach(System.out::println);
                              break;
                              case 3:
                                    cs.nextLine();
                                    cs.nextLine();
                                    System.out.println("Voila la Liste des Salle Existante ");
                                    salleService.listerSalles().forEach(System.out::println);
                                    System.out.println("Entrer l'id de la salle ");
                                    int idSalle=cs.nextInt();

                                    System.out.println("Entrer le Nom De la Salle ");
                                    String libele_Sale=cs.nextLine();

                                    cs.nextLine();
                                   
                                    System.out.println("Entrer la capacite de la Salle ");
                                    int capacitee=cs.nextInt();

                                    System.out.println("Choisir si la Salle doit etre Disponible ou non ");
                                    salleService.listerIsDisponible().forEach(System.out::println);
                                    int isDisponiblee=cs.nextInt();


                                    
                                salleService.updateSalle(idSalle, libele_Sale, capacitee, isDisponiblee);
                              break;
                              case 4:
                                     cs.nextLine();
                                     System.out.println("Voici la liste des Salle Disponible");
                                     salleService.findAll_Disponible(1).forEach(System.out::println);
                              break;
                            }
                          }while(choix!=5);
            break;  
            case 5:
                    dataBase.clearScreen();
                    System.out.println("Voila la Liste des Modules Existante Not Archivé ");
                    moduleService.listerModuleArchiveds(0).forEach(System.out::println);
                    System.out.println(" Entrer l'id du module Que vous voulez affecter:");
                    int choix_Module=cs.nextInt();
                    Module module_Affect=moduleService.rechercherParId(choix_Module);
                    if (module_Affect!=null){
                        System.out.println("Voila la Liste des Classes Existante Not Archivé ");
                        classeService.listerClasseArchiveds(0).forEach(System.out::println);
                        System.out.println(" Entrer l'id de la Classe Qui doit reçevoir le Module:");
                        int choix_Classe=cs.nextInt();
                        Classe Classe_Affect=classeService.rechercherParId(choix_Classe);
                        if (Classe_Affect!=null){
                            classe_ModuleService.ajouter(Classe_Affect, module_Affect);
                            System.out.println(" Module affecter avec succés");


                        }else{
                            System.out.println("  l'id de la Classe n'existe pas");

                        }
                    }else{
                            System.out.println("  l'id du Module  n'existe pas");

                    }
            break;
            case 6:
                    dataBase.clearScreen();
                    System.out.println("Voila la Liste des Classes Existante Not Archivé");
                    classeService.listerClasseArchiveds(0).forEach(System.out::println);
                    System.out.println(" Entrer l'id de la Classe ");
                    int choix_Classe=cs.nextInt();  
                    List<Module> mods=classe_ModuleService.Recherche_Modules_ByClasseId(choix_Classe);
                    if (mods!=null && !mods.isEmpty()){
                            mods.forEach(System.out::println);
                    } else {
                        System.out.println("Cette Classe n'a aucun module.");
                    }
            break;  
            case 7:
                    dataBase.clearScreen();
                    System.out.println("Voila la Liste des Professeur Existante Not Archivé");
                    professeurService.listerProfesseurArchiveds(0).forEach(System.out::println);
                    System.out.println(" Entrer l'id du professeur Que vous voulez affecter:");
                    int choix_Prof=cs.nextInt();
                    Professeur Prof_Affect=professeurService.rechercherParId(choix_Prof);
                    if (Prof_Affect!=null){
                        System.out.println("Voila la Liste des Classes Existante Not Archivé ");
                        classeService.listerClasseArchiveds(0).forEach(System.out::println);
                        System.out.println(" Entrer l'id de la Classe Qui doit reçevoir le Module:");
                        int choix_Classes=cs.nextInt();
                        Classe Classe_Affect=classeService.rechercherParId(choix_Classes);
                        if (Classe_Affect!=null){
                            classe_ProfesseurService.ajouter(Classe_Affect, Prof_Affect);
                            System.out.println(" Professeur affecter avec succés");


                        }else{
                            System.out.println("  l'id de la Classe n'existe pas");

                        }
                    }else{
                            System.out.println("  l'id du Prof  n'existe pas");

                    }
            break; 
            case 8:
            dataBase.clearScreen();
            System.out.println("Voila la Liste des Classes Existante ");
            classeService.listerClasseArchiveds(0).forEach(System.out::println);
            System.out.println(" Entrer l'id de la Classe ");
            int choiix_Classe = cs.nextInt();  
            List<Professeur> profs = classe_ProfesseurService.Recherche_Professeur_ByClasseId(choiix_Classe);
            if (profs != null && !profs.isEmpty()) {
                profs.forEach(System.out::println);
            } else {
                System.out.println("Cette Classe n'a aucun professeur.");
            }
        break; 
        case 9:
            cs.nextLine();
            System.out.println("voici les Classe exitante ");
            System.out.println("choisissez une :");

            coursService.listerClasse().forEach(System.out::println);
            int idClasse=cs.nextInt();
            if( classeService.rechercherParId(idClasse)==null ){
                System.out.println("Cette classe n'existe pas ");
                break;
            }else{
                System.out.println("voici les Module exixtant ");
                System.out.println("choisissez un :");

                coursService.listerModules().forEach(System.out::println);
                int idModule=cs.nextInt();
                if (moduleService.rechercherParId(idModule)==null){
                    System.out.println("Ce module n'existe pas ");
                    break;                
                }else{
                    System.out.println("voici les professeur existant ");
                    System.out.println("choisissez un :");

                    coursService.listerProfesseurs().forEach(System.out::println);
                    int idProfesseur=cs.nextInt();
                    if (professeurService.rechercherParId(idProfesseur)==null){
                        System.out.println("Ce professeur n'existe pas ");
                        break;  
                    }else{
                        System.out.println("voici les salle disponible ");
                        System.out.println("choisissez une :");
                        coursService.listerSalles().forEach(System.out::println);
                        int idSalle=cs.nextInt();

                        System.out.println("Entrez lA Durée du cours :");

                                int nombreHeure = 0; 

                                while (true) {
                                    try {
                                        nombreHeure = cs.nextInt(); 
                                        break; 
                                    } catch (InputMismatchException e) {
                                        System.out.println("Veuillez entrer un nombre  d'heures valide.");
                                        cs.next(); 
                                    }
                                }               
                                Classe classeSelect=coursService.listerClasse().get(idClasse-1);
                                Module moduleSelect=coursService.listerModules().get(idModule-1);
                                Professeur professeurSelect=coursService.listerProfesseurs().get(idProfesseur-1);
                                Salle salleSelect=coursService.listerSalles().get(idSalle-1);

                                String nombre_Heures = nombreHeure + "H";

                                Cours cours=new Cours(0,classeSelect.getLibelle(),moduleSelect.getLibelle(), professeurSelect.getLibelle(),salleSelect.getLibelle(),nombre_Heures);
                                if(coursService.ajouterCours(cours)){
                                    System.out.println("Cours enregister avec success");
                                }else{
                                    System.out.println("Erreur insertion");
                                }


                    }
                                

                }
           
            }
           
        break; 
        case 10:
            System.out.println("Voicie l'ensemble des Cours Plannifier");
            coursService.listerCours().forEach(System.out::println);

        break;  
        case 11:
            cs.nextLine();
            System.out.println("Choisir une Classe");
            coursService.listerClasse().forEach(System.out::println);
            int id_Classe=cs.nextInt();
            if (classeService.rechercherParId(id_Classe)!=null){
                Classe classe_Select=coursService.listerClasse().get(id_Classe-1);
                List<Cours> crs=coursService.rechercherParClasse(classe_Select.getLibelle());
                    if (crs!=null && !crs.isEmpty()){
                            crs.forEach(System.out::println);
                    } else {
                        System.out.println("Cette Classe n'a aucun cours.");
                    }

            }else{
                System.out.println("Cette classe n'existe pas");
            }
            
            
        break;
        case 12:
        cs.nextLine();
            System.out.println("Choisir un professeur");
            coursService.listerProfesseurs().forEach(System.out::println);
            int id_Profs=cs.nextInt();
            if (professeurService.rechercherParId(id_Profs)!=null){
                    Professeur Prof_Select=coursService.listerProfesseurs().get(id_Profs-1);
                    List<Cours> cr_s=coursService.rechercherParProf(Prof_Select.getLibelle());
                    if (cr_s!=null && !cr_s.isEmpty()){
                            cr_s.forEach(System.out::println);
                    } else {
                        System.out.println("Ce Prof n'a aucun cours.");
                    }          
                               
        }else{
            System.out.println("L'id du prof n'existe pas ");
        }
            }
            
        }while(choix!=13);
    }
}
