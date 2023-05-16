insert into Gebruiker values (1, 'van der Geer', 'Java', false, 'HANDELAAR','cornevandergeer@gmail.com','Corne','12345','Apeldoorn');
insert into Gebruiker values (2, 'Crombach', 'Java', false, 'HANDELAAR','leon_crombach@hotmail.com','Leon','12345','Deventer');
insert into Gebruiker values (3, 'Janssens', 'Kotlin', false, 'HANDELAAR','bramjanssens@gmail.com','Bram','42','Utrecht');
insert into `Gebruiker Bezorgwijzes` values (1, 'THUISAFHALEN');
insert into `Gebruiker Bezorgwijzes` values (2, 'THUISAFHALEN');
insert into `Gebruiker Bezorgwijzes` values (2, 'VERSTUREN');
insert into `Gebruiker Bezorgwijzes` values (3, 'THUISAFHALEN');
insert into `Gebruiker Bezorgwijzes` values (3, 'VERSTUREN');
insert into `Gebruiker Bezorgwijzes` values (3, 'MAGAZIJNBELASTINGDIENST');
insert into Advertentie values (1, 'THUISAFHALEN', 'PRODUCT','een mooie fiets om mee te fietsen.', 100.00, 'BESCHIKBAAR', 'mooie fiets', 1);
insert into Advertentie values (2, 'MAGAZIJNBELASTINGDIENST', 'PRODUCT', 'Een knuffel om mee te gooien als het te langzaam gaat.', 42.00, 'ONDERWEG', 'Elmo', 3);
insert into Advertentie values (3, null, 'DIENST','ik bied mezelf aan als DM voor D&D.', 75.99, 'BESCHIKBAAR', 'GM voor D&D', 2);
insert into Advertentie values (4, 'VERSTUREN', 'PRODUCT','echte sneeuw van de noordpool.', 99.34, 'BESCHIKBAAR', 'sneeuw', 2);
insert into Advertentie values (5, null, 'DIENST','ik bied privé lesjes aan voor je OCP, nu voor een vriendenprijsje.', 500.00, 'BESCHIKBAAR', 'privé-les OCP', 3);
insert into Advertentie values (6, 'MAGAZIJNBELASTINGDIENST', 'PRODUCT','Hij doet het nog prima, APK tot 16 mei 2023', 50.00, 'BESCHIKBAAR', 'prima auto', 3);
insert into Bod values (1, 42, false, '2023-05-15 16:42:35.906000', 1, 3);
insert into Reactie values (1, 'zijn de wielen nog heel?', '2023-05-15 15:04:35.906000', 1, 2);
insert into Reactie values (2, 'zeker! ze doen het allebei nog', '2023-05-15 15:15:35.906000', 1, 1);
insert into Reactie values (3, 'Dan wil ik hem wel kopen! Zie mijn bod', '2023-05-15 16:42:42.906000', 1, 3);




