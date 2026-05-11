Moja praca z platformą Railway(Bohdan Shvets 77364)
W ramach projektu byłem odpowiedzialny za wdrożenie aplikacji na platformę Railway. Poniżej znajduje się szczegółowy opis moich działań, sukcesów oraz napotkanych problemów technicznych.

Co konkretnie zrobiłem:
Konfiguracja środowiska CLI: Zamiast prostego przesyłania plików przez przeglądarkę, zainstalowałem i skonfigurowałem Railway CLI. Pozwoliło mi to na bezpośrednią interakcję z serwerem z poziomu terminala, co jest standardem w profesjonalnej pracy DevOps.

Proces Wdrożenia (Deployment):

Przeprowadziłem autoryzację konta za pomocą komendy railway login.

Połączyłem lokalny kod źródłowy z chmurą za pomocą railway link.

Wykonałem finalny upload aplikacji komendą railway up, monitorując proces budowania obrazu w czasie rzeczywistym.

Networking i Zarządzanie Domeną: W ustawieniach projektu wygenerowałem publiczną domenę, skonfigurowałem porty oraz sprawdziłem stabilność połączenia z serwerem.

Sukcesy:
Automatyzacja: Udało mi się osiągnąć status Online przy pierwszej próbie przesyłania kodu przez CLI.

Optymalizacja: Railway automatycznie rozpoznał strukturę projektu Maven/Java, co skróciło czas wdrożenia do mniej niż 2 minut.

Integracja: Poprawnie połączyłem logi serwera z panelem sterowania, co pozwoliło na bieżący monitoring aplikacji.

Trudności i ich rozwiązanie:
Whitelabel Error Page (404): Po uruchomieniu domeny strona wyświetlała błąd 404.

Rozwiązanie: Musiałem wejść w logi serwera na Railway, aby sprawdzić, czy proces Java wystartował poprawnie. Okazało się, że aplikacja potrzebowała zdefiniowania odpowiedniej zmiennej środowiskowej dla portu.

Brak uprawnień do repozytorium: Na początku Railway nie widział kodu.

Rozwiązanie: Musiałem przejść przez proces Configure GitHub App i ręcznie nadać uprawnienia do konkretnego repozytorium, co nauczyło mnie zarządzania dostępem w narzędziach chmurowych.

Zarządzanie zasobami: Musiałem monitorować użycie procesora i RAM-u w panelu Railway, aby upewnić się, że darmowy limit (Trial) nie zostanie przekroczony podczas testów zespołu.
https://deploycraft-api-production.up.railway.app/hello



Wdrażanie na Render (Oleksandr Zavoloka 77427)
Utworzenie konta: Rejestracja w serwisie Render.com і wybór darmowego planu (Free Tier), który nie wymaga podpięcia karty płatniczej.

Tworzenie usługi: Na Dashboardzie klikamy New + -> Web Service.

Połączenie z GitHub: Wklejamy bezpośredni link do publicznego repozytorium: https://github.com/Kaniuk-Ihor-77372/deploycraft-api.

Proces konfiguracji w kreatorze:

Name: wpisujemy deploycraft-77427-api.

Region: wybieramy Frankfurt (EU Central), aby zapewnić niskie opóźnienia w Polsce.

Language: wybieramy Docker (w przypadku braku dostępności Java Runtime w panelu, co gwarantuje stabilność środowiska).

Branch: main.

Instance Type: upewniamy się, że wybrano Free ($0/month).

Komendy budowania i uruchamiania:

Build Command: sh mvnw clean install -DskipTests (użycie przedrostka sh jest kluczowe dla uniknięcia problemów z uprawnieniami pliku wykonywalnego).

Start Command: java -jar target/*.jar.

Weryfikacja:

Po kliknięciu Create Web Service czekamy około 5-7 minut na zakończenie procesu Building i Deploying.

Gdy pojawi się zielony status Live, przechodzimy pod adres: https://deploycraft-77427-api.onrender.com/hello.

Napotkane trudności i wnioski:
Podczas procesu wdrażania napotkano szereg problemów technicznych, które wynikały z różnic między środowiskiem lokalnym a chmurowym:

Problemy z uprawnieniami (Permission Denied): Skrypt mvnw (Maven Wrapper) nie posiadał uprawnień do wykonywania w środowisku Linux platformy Render. Problem rozwiązano poprzez dodanie komendy sh przed polem build, co pozwoliło na poprawne zbudowanie paczki .jar.

Brak wykrywania środowiska Java: Platforma Render automatycznie sugerowała Node.js zamiast Javy. Z powodu niewielkiego doświadczenia w konfiguracji serwerów chmurowych, początkowo próbowano wymusić zmianę w ustawieniach Runtime, jednak finalnie najskuteczniejszym rozwiązaniem okazało się wykorzystanie Dockera, co zapewniło izolację i pewność, że aplikacja zadziała na Java 17.

Błąd 404 (Whitelabel Error Page): Po pierwszym uruchomieniu strona główna zwracała błąd. Wymagało to zrozumienia, że aplikacja Spring Boot nie posiada zdefiniowanego widoku dla ścieżki głównej (/), a poprawny wynik znajduje się pod dedykowanym punktem końcowym /hello.

Ograniczenia Free Tier: Darmowe instancje na Render "zasypiają" po okresie bezczynności, co powoduje, że pierwsze uruchomienie strony po dłuższej przerwie trwa kilkadziesiąt sekund (tzw. "cold start").


Montaż i przygotowanie materiału wideo (Oleksandr Zavoloka 77427)
Narzędzia: Do nagrania ekranu wykorzystano systemowe narzędzie Windows (Game Bar) / OBS Studio, a do prostego montażu program CapCut / Clipchamp.

Proces: Nagranie zostało zrealizowane w sposób ciągły, aby pokazać autentyczność procesu — od panelu kontrolnego Render, przez logi serwera, aż po finalne wywołanie API w przeglądarce.

Doświadczenia z montażem: W przeciwieństwie do konfiguracji serwera chmurowego, proces nagrywania i montażu wideo przebiegł bardzo sprawnie i bez żadnych problemów technicznych.

Finalny materiał: Wideo zostało przycięte tak, aby skupić się na najważniejszych elementach: potwierdzeniu tożsamości studenta (imię, nazwisko, nr albumu) oraz poprawnym działaniu endpointu /hello. Plik wynikowy jest czytelny i gotowy do weryfikacji przez prowadzącego.
