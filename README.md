# object-kotlin

『오브젝트』(조영호) 예제를 Kotlin으로 옮겨 실습하고, 설계 의도와 깨달은 점을 장별로 기록하는 스터디 저장소.

회사에서 AI가 작성한 코드를 보면서 뭔가 깔끔하지 않다고 느꼈는데, 막상 뭐가 문제인지 설명하고 어떻게 바꿔야 할지는 어려워 학습.

책은 Java, 업무는 Kotlin이라 직접 옮기면서 공부.

## 진행 방식

1. 책의 구조 그대로 Kotlin으로 이식 + 테스트 (커밋)
2. Kotlin스럽게 리팩터링 (별도 커밋)


## 구조

```
object-kotlin/
├── chapter01/   # 각 장: src/ + README.md
├── chapter02/
└── ...
```

## 실행

JDK 21 필요.

```
./gradlew :chapter01:test
```
