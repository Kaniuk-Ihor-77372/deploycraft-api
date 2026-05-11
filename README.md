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



## 🚀 Wdrażanie na Render (Oleksandr Zavoloka 77427)

### 🛠 Proces konfiguracji krok po kroku

1.  **Utworzenie konta**: Rejestracja w serwisie [Render.com](https://render.com) i wybór darmowego planu (**Free Tier**), który nie wymaga podpięcia karty płatniczej.
2.  **Tworzenie usługi**: Na Dashboardzie wybieramy przycisk **New +** -> **Web Service**.
3.  **Połączenie z GitHub**: Wklejamy bezpośredni link do publicznego repozytorium: `https://github.com/Kaniuk-Ihor-77372/deploycraft-api`.
4.  **Konfiguracja w kreatorze**:
    * **Name**: `deploycraft-77427-api`
    * **Region**: `Frankfurt (EU Central)` (najniższe opóźnienia dla Polski).
    * **Language**: **Docker** (wybrany w celu zapewnienia stabilności środowiska Java 17).
    * **Branch**: `main`
    * **Instance Type**: **Free** ($0/month).
5.  **Weryfikacja**:
    * Po kliknięciu **Create Web Service** proces budowania i wdrażania trwa ok. 5-7 minut.
    * Gdy pojawi się status **Live**, aplikacja jest dostępna pod adresem: [https://deploycraft-77427-api.onrender.com/hello](https://deploycraft-77427-api.onrender.com/hello).

---

### ⚠️ Napotkane trudności i wnioski

Podczas procesu wdrażania wystąpiło kilka wyzwań technicznych, które wymagały analizy różnic między środowiskiem lokalnym a chmurowym:

* **Brak wykrywania środowiska Java**: Platforma Render domyślnie sugerowała Node.js. Z powodu niewielkiego doświadczenia w konfiguracji usług cloud, początkowo próbowano wymusić zmianę w ustawieniach Runtime, jednak finalnie najskuteczniejszym rozwiązaniem okazało się wykorzystanie **Dockera**, co zapewniło pełną izolację aplikacji.
* **Błąd 404 (Whitelabel Error Page)**: Strona główna zwracała błąd po uruchomieniu. Wymagało to zrozumienia, że Spring Boot bez zdefiniowanego widoku dla ścieżki `/` wyświetla stronę błędu, a poprawny wynik znajduje się pod adresem `/hello`.
* **Ograniczenia Free Tier**: Instancje na Render "zasypiają" po okresie bezczynności. Powoduje to tzw. "cold start", czyli wydłużony czas oczekiwania (nawet kilkadziesiąt sekund) przy pierwszym wejściu na stronę po przerwie.

---

### 🎥 Montaż i przygotowanie materiału wideo

* **Narzędzia**: Do nagrania ekranu wykorzystano narzędzia systemowe **Windows (Game Bar)** oraz **OBS Studio**. Montaż wykonano w programie **CapCut / Clipchamp**.
* **Proces**: Nagranie zrealizowano w sposób ciągły, prezentując autentyczny przepływ pracy: od panelu Render, przez logi, aż po wywołanie API.
* **Wnioski z montażu**: Proces przygotowania wideo przebiegł bardzo sprawnie i bez żadnych problemów technicznych.
* **Finalny materiał**: Film skupia się na kluczowych elementach: potwierdzeniu tożsamości (**Oleksandr Zavoloka, 77427**) oraz demonstracji działającego punktu końcowego `/hello`.
