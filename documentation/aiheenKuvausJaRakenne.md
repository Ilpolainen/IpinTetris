# Aihemäärittely

**Aihe:** Reaaliaikainen Tetris, jota on tarkoitus pystyä pelaamaan näppäimistoltä ja sen saa alkamaan Swing-kayttoliittymästä. Modifikaatioita, joita konfiguroidaan käyttöliittymästä, toteutetaan taitojen mukaan. Näitä ovat esimerkiksi palikoiden värien valinta, kentän koko yms..

**Käyttäjät:** Taman kurssin opiskelijat ja opettajat sekä muut satunnaiskäyttäjät.

**Kaikkien käyttäjien toiminnot:**


- Pelin konfigurointi (esim. kentän koko, pelin vaikeusaste ja palikoiden värit)
- Pelin käynnistys
- Palasen kääntely
- Palasen liikuttaminen oikealle
- Palasen liikuttaminen vasemmalle
- Palasen tippumisnopeuden lisääminen
- Pelin keskeyttäminen

![Active Game Components](Active Game Components.jepg)
![DestroyRowsSekvenssikaavio](DestroyRowsSequenceDiagram.jpg)

## Rakennekuvaus

Peli koostuu pelilogiikasta (Logic) ja sitä käyttävästä peliluupista (GameLoop), joka kutsuu pelilogiikan metodia UpDate() booleanparametreillä, jotka pelilooppi pyytää aina näppäimistönkuuntelijalta (KeyPressListener). Myös piirtäjä (abstracti Renderer, tässä versiossa MyFirstRenderer) käyttää logiikkaa. Renderluuppi puolestaan pyytää piirtäjää piirtämään pelitilanteesta kuvan. Luupit toimivat omissa threadeissään.

Logiikka taas koostuu rakenneosasista Table ja Piece (abstracti luokka, jolla useita aliluokkia). Table sisältää muunmuassa taulukon Blockeja, jotka ovat perusrakenneosasia pelissä. Piece koostuu myös neljästä blockista. Block ja Piece toteuttavat rajapinnan Movable, joilla tulee olla metodit moveDown(), moveUp(), moveLeft(), ja moveRight(). Piece toteuttaa nämä metodit yksinkertaisesti kutsumalla jokaiselle sisältämälleen Blockille vastaavat kutsut. Piecen lisämetodit rotateLeft() ja rotateRight() kutsuvat myös Blockien alkeellisempia liikkumiskäskyjä. 

Logiikalla on muutamia apuluokkia nimeltään LevelManager, LimitGuard, RowManager ja PieceGenerator. Levelmanager hoitaa pisteenlaskun ja leveleilä etenemisen, sekä laskee tuhottujen rivien määrän. RowManager sisältää rivioperaatioita hoitavat metodit, ja LimitGuard toimii apuna pelikentän ja siirrettävän palikan kontakteista. Piecegenerator luo tarvittaessa uuden piecen. Logiikka osaa tarvittaessa liittää Piecen "current" sisältämät blockit Table -luokan taulukkoon, ja kutsuu samalla piecegeneratorilta uutta palasta.

Lisäksi logiikka käyttää abstractin Command -luokan aliluokkia, joita käytetään aina, kun update() metodin kutsussa on niitä vastaavat parametrit.

Pelin käynnistäminen ja alkuvalikossa selaaminen, sekä optionsien valitseminen taphtuu suhtkoht monimutkaisessa käyttöliittymäkokonaisuudessa, jota en sen tarkemmin selvennä, sillä pelin voi käynnistää normaaliasetuksilla ilman niihin sekaantumista. Mainittakoon vain, että StateCoordinator on ActionListener, joka kuuntelee StartingScreenin sekä GameScreenin nappulakomentojakomentoija ja osaa näiden perusteella koordinoida esimerkiksi sitä, mikä ikkuna milloinkin on aktiivinen, onko peli käynnissä yms.. GameCenterUnit on pelin keskusyksikkö, joka alustaa ja rakentaa pelin, ja jolta tarvittaessa voi kysyä tietoja eri olioiden tiloista, sillä se toimii myös linkkinä tarvittaville yhteyksille.  

[käyttöohjeet](kayttoohjeet.md)
