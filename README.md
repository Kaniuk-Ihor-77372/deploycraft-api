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
