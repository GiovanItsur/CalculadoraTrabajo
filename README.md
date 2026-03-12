Este proyecto es "Calculate Tip" de Android hacia un enfoque multiplataforma utilizando Kotlin Compose Multiplatform (KMP).

OBJETIVOS:
ViewModel en commonMain: Se implementó TipCalculatorViewModel extendiendo de ViewModel lo que dejó compartir el estado y la lógica entre Android y Desktop.
Estado Reactivo: Se eliminaron los estados locales ineficientes (remember { mutableStateOf() }) de la interfaz dando el control a un StateFlow manejado por el ViewModel.

INSTRUCCIONES:

Para Desktop:
1. Abre el proyecto en IntelliJ IDEA o Android Studio (con el plugin KMP).
2. Esperamos a que IntelliJ termine de cargar todo lo necesario para el funcionamiento correcto de nuestro proyecto.
3. Seleccionaremos en la parte superior para cambiar el "composeApp" a "composeApp [jvm]".
4. Correremos en programa con el triangulo color verde de la parte superior a un costado de "composeApp".

<img width="369" height="46" alt="image" src="https://github.com/user-attachments/assets/5dde4e7d-04dd-48bf-88c8-b2e641977562" />

Para Android:
1. Selecciona la configuración de ejecución "composeApp".
2. Selecciona un emulador o dispositivo físico en la parte izquierda de la opción anterior.
3. Correremos en programa con el triangulo color verde de la parte superior a un costado de "composeApp".

<img width="488" height="51" alt="image" src="https://github.com/user-attachments/assets/7b1b15bc-540e-4485-9c80-5aa17757ac38" />

<img width="776" height="589" alt="image" src="https://github.com/user-attachments/assets/14e5329f-6189-4b1e-9154-eb637027048a" />
<img width="773" height="586" alt="image" src="https://github.com/user-attachments/assets/61360f37-d9d7-45f9-8127-729b99918f8d" />




