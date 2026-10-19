### 상속

부모 클래스가 제공하는 모든 인터페이스(외부에 공개된 메서드 목록)를 자식 클래스가 물려받는다.

```kotlin
// 부모 클래스
abstract class DiscountPolicy(
    private val conditions: MutableList<DiscountCondition> = mutableListOf()
) {
    fun calculateDiscountAmount(screening: Screening): Money {
        for (each in conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
```

```kotlin
// 자식 클래스
class PercentDiscountPolicy(
    private val percent: Double,
    private val conditions: MutableList<DiscountCondition>
) : DiscountPolicy(conditions.toMutableList()) {
    override fun getDiscountAmount(screening: Screening): Money = screening.getMovieFee().times(percent)
}

class AmountDiscountPolicy(
    private val discountAmount: Money,
    private val conditions: MutableList<DiscountCondition>
) : DiscountPolicy(conditions.toMutableList()) {
    override fun getDiscountAmount(screening: Screening): Money = this.discountAmount
}
```


### 업캐스팅

자식 클래스는 부모 클래스의 인터페이스를 모두 물려받았기 때문에 부모 클래스 대신 사용할 수 있다.
이렇게 자식 클래스가 부모 클래스 자리를 대신하는 것을 **업캐스팅**이라 한다.

```kotlin
class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountPolicy: DiscountPolicy
) {
    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money =
        fee.minus(discountPolicy.calculateDiscountAmount(screening))
}
```

`Movie`는 부모 클래스인 `DiscountPolicy`에만 의존한다.
그래서 `Movie`는 얼마를 할인받을 수 있는지 물어볼 뿐, 어떤 할인 정책으로 할인되는지는 모른다.


### 책임과 협력

할인 금액을 계산하는 **책임**은 `DiscountPolicy`에게 있다.
`Movie`는 `DiscountPolicy`에게 할인 금액을 물어보고, 그 응답으로 요금을 계산한다.
이렇게 객체들이 요청과 응답을 주고받으며 일을 해내는 것을 **협력**이라 한다.
