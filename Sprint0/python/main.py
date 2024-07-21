import datetime


def cashRegister(ticket):
    try:
        totalPrice = 0
        iva = .16
        for i in ticket:
            values = i.split(" - ")
            totalPrice += float(values[0]) * float(values[2].replace(",", "."))
        totalPrice += totalPrice * iva
        return f"Total a pagar: {round(totalPrice, 2)}€\nFecha de compra: {datetime.datetime.now().strftime('%Y-%m-%d')}"
    except:
        return "Invalid ticket"


if __name__ == "__main__":
    ticket = [
        "1 - filete de ternera - 30,23",
        "4 - coca cola - 4,20",
        "-2 - coca cola - 1,40",
        "1 - pan - 0,90"
    ]
    print(cashRegister(ticket))
    print("-"*30)
    print(cashRegister([]))
