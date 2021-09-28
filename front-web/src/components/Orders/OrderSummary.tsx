import { formatPrice } from "./helpers";
import { Product } from "./types";


type Props = {
    selectedProducts: Product[];
    onSubmit: () => void;
}

function OrderSummary({ selectedProducts, onSubmit }: Props) {
    return (
        <div className="order-summary-container">
            <div className="order-summary-content">
                <div>
                    <span className="amount-selected-container">
                        <strong className="amount-selected">{selectedProducts.length}</strong> 
                        {selectedProducts.length > 1 ? 'PEDIDOS SELECIONADOS' : 'PEDIDO SELECIONADO'}
                    </span>
                    <span className="order-summary-total">
                        <strong className="amount-selected">{formatPrice(selectedProducts.reduce((sum, actual) => sum + actual.price, 0))}</strong> 
                        VALOR TOTAL
                    </span>
                </div>
                <button className="order-summary-make-order" onClick={onSubmit}>
                    FAZER PEDIDO
                </button>
            </div>
        </div>
    );
}

export default OrderSummary;